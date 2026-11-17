/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.download.services;

import com.matrix.download.model.User;
import com.matrix.download.util.PassEncrypt;
import com.matrix.download.user.repository.UserRepository;
import com.matrix.download.util.ErrorCode;
import com.matrix.download.util.JSonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public String findUser(long id, long sysUser) {
        setLoginUser(sysUser);
        User usr = repo.findOne(id);
        if (usr != null) {
            return JSonUtil.toPrettyPrint(JSonUtil.mergeJSON(JSonUtil.msgJSON(ErrorCode.E000, id), JSonUtil.toJSON(usr, "Public")));
        } else {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E003, id));
        }
    }

    @Override
    public String createUser(User usr, String email, Date dateOfBirth) {
        User sysUsr = repo.findOne(usr.getCreatedBy());
        Date localDate = new Date();
        JSONObject o = new JSONObject();
        if (sysUsr != null) {
            sysUsr.setLastLogin(localDate);
            repo.save(sysUsr);
            usr.setUpdatedBy(sysUsr.getUserId());
        }/*else{
            o.put(errorcode.toString(), "E002");
            o.put(errordescription.toString(), "Invalid SysUser");
            o.put(uid.toString(),  usr.getCreatedBy());
            return new ResponseEntity<>(o, HttpStatus.BAD_REQUEST);
        }*/
        usr.setCreated(localDate);
        usr.setIsActive("Y");
        usr.setUpdated(localDate);

        usr.setPwd_lastset(localDate);
        usr.setPwd_Expiration(null);
        //if(!email.isEmpty())
        usr.setEmail(email);
        //if(dateOfBirth!=null)
        usr.setDate_Of_Birth(dateOfBirth);
        repo.save(usr);

        if (usr.getUserId() != 0) {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, usr.getUserId()));
        }
        return null;
    }

    @Override
    public String updateUser(long id, long sysUser, String usrName, String usrPass, String email, Date dateOfBirth) {
        User usr = repo.findOne(id);
        User sysUsr = repo.findOne(sysUser);
        Date localDate = new Date();
        if (sysUsr != null) {
            sysUsr.setLastLogin(localDate);
            repo.save(sysUsr);
        }
        JSONObject o = new JSONObject();
        if (usr != null) {
            if (usrName != null) {
                usr.setUserName(usrName);
            }
            if (usrPass != null) {
                usr.setUserPass(PassEncrypt.encrypt(usrPass));
            }
            usr.setPwd_lastset(localDate);

            if (email != null) {
                usr.setEmail(email);
            }
            if (dateOfBirth != null) {
                usr.setDate_Of_Birth(dateOfBirth);
            }
            usr.setUpdatedBy(sysUser);
            usr.setUpdated(localDate);
            repo.save(usr);
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
        }
        return null;
    }

    @Override
    public String activeUser(long id, long sysUsr, String active) {
        User usr = repo.findOne(id);
        if (usr != null) {
            usr.setIsActive(active);
            usr.setUpdated(new Date());
            usr.setUpdatedBy(sysUsr);
            repo.save(usr);
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
        } else {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E003, id));
        }
    }

    @Override
    public void setLoginUser(long id) {
        User usr = repo.findOne(id);
        if (usr != null) {
            usr.setLastLogin(new Date());
            repo.save(usr);
        }
    }

    @Override
    public String validateUser(String user, String password, String chain) {

        if ("Provecomer".equalsIgnoreCase(chain)) {
            StringBuffer sb = new StringBuffer();
            String inputLine, response;
            try {
                String url = "http://www.proveccm.com/webPrvd/LoginProvecomerNpSrv";
                url = url.concat("?proveedor=").concat(user)
                        .concat("&password=").concat(password)
                        .concat("&enviar1=enviar1")
                        .concat("&enviar1.x=29")
                        .concat("&enviar1.y=6");
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                System.out.println(con.getHeaderFields());
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }
                in.close();
                response = sb.toString();
                if (response.contains(" Error en clave o contraseña !!!!!")) {
                   return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E003, 0));
                } else {
                   return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, 0));
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        } else {
             return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E002, 0));
        }
        return null;
    }
}

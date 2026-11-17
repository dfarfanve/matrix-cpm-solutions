package com.download.service;

import com.download.model.User;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import com.download.util.MatrixUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.download.repository.UserRepo;

@Service
public class CreateUserService {

    @Autowired
    UserRepo userRepo;

    public String createUser(String sysUser, String strName, String strPass, int clientId, String clientName, int chainId, String email, Date dateOfBirth, String provider) {
        User usr = new User();
        Date localDate = new Date();
        usr.setUserName(strName);
        usr.setUserPass(strPass);
        usr.setCreatedBy(sysUser);
        usr.setChainId(chainId);
        usr.setClientId(clientId);
        usr.setClientName(clientName);
        usr.setProvider(provider);
        usr.setCreated(localDate);
        usr.setIsActive("Y");
        usr.setUpdated(localDate);
        usr.setPwd_lastset(localDate);
        usr.setPwd_Expiration(null);
        if (email != null) {
            if (MatrixUtil.validateEmail(email)) {
                usr.setEmail(email);
            } else {
                return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E004, usr.getUserId()));
            }
        }
        usr.setDate_Of_Birth(dateOfBirth);
        userRepo.save(usr);

        if (usr.getUserId() != 0) {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, usr.getUserId()));
        }
        return null;
    }
}

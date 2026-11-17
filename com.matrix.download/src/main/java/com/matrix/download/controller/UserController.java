package com.matrix.download.controller;



import com.google.gson.JsonObject;
import com.matrix.download.model.User;
import com.matrix.download.util.PassEncrypt;
import com.matrix.download.user.repository.UserRepository;
import com.matrix.download.services.UserService;
import java.util.Date;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository repo;
         
    @Autowired
    UserService userService;
    //Get User by id given
    @RequestMapping(value = "/finduser", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String findUser(
           @RequestHeader(value="id", required=true) Long id,
           @RequestHeader(value="sysUser", required=true) Long sysUser)
    {  
      return userService.findUser(id,sysUser);
      
    }
    
    @RequestMapping(value = "/validateuser", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String validateUser(
           @RequestHeader(value="user",  required=true) String strName,
            @RequestHeader(value="pass",  required=true) String strPass,
             @RequestHeader(value="chainName",  required=true) String chainName)
    {  
      return userService.validateUser(strName, strPass, chainName);
      
    }
    
    // CREATE
    @RequestMapping(value = "/createuser", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String createUser(
            @RequestHeader(value="sysUser", required=true) long sysUser,
            @RequestHeader(value="name",  required=true) String strName,
            @RequestHeader(value="pass",  required=true) String strPass,
            @RequestHeader(value="clientId",  required=true) int clientId,
            @RequestHeader(value="clientName",  required=true) String clientName,
            @RequestHeader(value="chainName",  required=true) String chainName,
            @RequestHeader(value="email",  required=false) String email,
            @RequestHeader(value="dateofbirth",  required=false) Date dateofbirth)
    { 
        User usr = new User();
        usr.setUserName(strName);
        usr.setUserPass(PassEncrypt.encrypt(strPass));
        usr.setCreatedBy(sysUser);
        usr.setChainName(chainName);
        usr.setClientID(clientId);
        usr.setClientName(clientName);
        
       return userService.createUser(usr,email,dateofbirth);
    }    
    
    
    @RequestMapping(value = "/updateuser", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String updateUser(
            @RequestHeader(value="id" , required=true) long id,
            @RequestHeader(value="sysUser", required=true) long sysUser,
            @RequestHeader(value="name", required=false) String strName,
            @RequestHeader(value="pass", required=false) String strPass,
            @RequestHeader(value="email",  required=false) String email,
            @RequestHeader(value="dateofbirth",  required=false) Date dateofbirth)
    { 
 
       return userService.updateUser(id,sysUser,strName, strPass,email,dateofbirth);
    }
    
    
    @RequestMapping(value = "/activateuser", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String activeUser(
            @RequestHeader(value="id",required=true) Long id,
            @RequestHeader(value="sysUser", required=true) long sysUser,
            @RequestHeader(value="active",required=true) String active) { 
 
       return userService.activeUser(id,sysUser,active);
    }
}

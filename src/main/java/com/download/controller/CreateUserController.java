package com.download.controller;

import com.download.service.CreateUserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    @Autowired
    CreateUserService userService;

    @RequestMapping(value = "/createuser", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String createUser(
            @RequestHeader(value = "sysUser", required = true) String sysUser,
            @RequestHeader(value = "name", required = true) String strName,
            @RequestHeader(value = "pass", required = true) String strPass,
            @RequestHeader(value = "clientId", required = true) int clientId,
            @RequestHeader(value = "clientName", required = true) String clientName,
            @RequestHeader(value = "provider", required = false) String provider,
            @RequestHeader(value = "chainId", required = true) int chainId,
            @RequestHeader(value = "email", required = false) String email,
            @RequestHeader(value = "dateofbirth", required = false) Date dateofbirth) {
        return userService.createUser(sysUser, strName, strPass, clientId, clientName, chainId, email, dateofbirth, provider);
    }
}

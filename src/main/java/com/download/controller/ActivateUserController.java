package com.download.controller;

import com.download.service.ActivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivateUserController {

    @Autowired
    ActivateUserService userService;

    @RequestMapping(value = "/activateuser", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String activeUser(
            @RequestHeader(value = "id", required = true) int id,
            @RequestHeader(value = "sysUser", required = true) String sysUser,
            @RequestHeader(value = "active", required = true) String active) {

        return userService.activateUser(id, sysUser, active);
    }
}

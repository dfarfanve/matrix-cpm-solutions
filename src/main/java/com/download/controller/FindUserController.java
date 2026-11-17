package com.download.controller;

import com.download.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindUserController {

    @Autowired
    FindUserService userService;

    @RequestMapping(value = "/finduser", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String findUser(
            @RequestHeader(value = "id", required = true) int id,
            @RequestHeader(value = "sysUser", required = true) String sysUser) {
        return userService.findUser(id, sysUser);

    }

   
}

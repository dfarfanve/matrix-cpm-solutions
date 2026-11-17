package com.download.controller;

import com.download.service.ValidateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateUserController {

    @Autowired
    ValidateUserService userService;

    @RequestMapping(value = "/validateuser", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String validateUser(
            @RequestHeader(value = "user", required = true) String strName,
            @RequestHeader(value = "pass", required = true) String strPass,
            @RequestHeader(value = "chainId", required = true) int chainId) {
        return userService.validateUser(strName, strPass, chainId);
    }
}

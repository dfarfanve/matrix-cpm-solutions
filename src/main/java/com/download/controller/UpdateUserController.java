package com.download.controller;

import com.download.service.UpdateUserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserController {

    @Autowired
    UpdateUserService userService;

    @RequestMapping(value = "/updateuser", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String updateUser(
            @RequestHeader(value = "id", required = true) int id,
            @RequestHeader(value = "sysUser", required = true) String sysUser,
            @RequestHeader(value = "name", required = false) String strName,
            @RequestHeader(value = "pass", required = false) String strPass,
            @RequestHeader(value = "email", required = false) String email,
            @RequestHeader(value = "dateofbirth", required = false) Date dateofbirth) {

        return userService.updateUser(id, sysUser, strName, strPass, email, dateofbirth);
    }
}

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
public class UpdateUserService {

    @Autowired
    UserRepo userRepo;

    public String updateUser(int id, String sysUser, String usrName, String usrPass, String email, Date dateOfBirth) {
        User usr = userRepo.findOne(id);
        if (usr != null) {
            boolean toUpdate = false;
            Date localDate = new Date();
            if (usrName != null) {
                usr.setUserName(usrName);
                toUpdate = true;
            }
            if (usrPass != null) {
                usr.setUserPass(usrPass);
                toUpdate = true;
                usr.setPwd_lastset(localDate);
            }
            if (MatrixUtil.validateEmail(email)) {
                toUpdate = true;
                usr.setEmail(email);
            }
            if (dateOfBirth != null) {
                toUpdate = true;
                usr.setDate_Of_Birth(dateOfBirth);
            }
            if (toUpdate) {
                usr.setUpdatedBy(sysUser);
                usr.setUpdated(localDate);
                userRepo.save(usr);
                return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
            }
        }
        return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E006, id));
    }
}

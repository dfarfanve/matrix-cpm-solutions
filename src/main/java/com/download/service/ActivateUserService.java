package com.download.service;

import com.download.model.User;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.download.repository.UserRepo;

@Service
public class ActivateUserService {

    @Autowired
    UserRepo userRepo;

    
    public String activateUser(int id, String sysUsr, String active) {
        User usr = userRepo.findOne(id);
        if (usr != null) {
            if ("Y".equalsIgnoreCase(active) || "N".equalsIgnoreCase(active)) {
                usr.setIsActive(active);
                usr.setUpdated(new Date());
                usr.setUpdatedBy(sysUsr);
                userRepo.save(usr);
                return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
            } else {
                return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E008, id));
            }
        }
        return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E006, id));
    }
}

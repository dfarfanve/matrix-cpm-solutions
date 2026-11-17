package com.download.service;

import com.download.model.User;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.download.repository.UserRepo;

@Service
public class FindUserService {

    @Autowired
    UserRepo userRepo;

    public String findUser(int id, String sysUser) {
        User usr = userRepo.findOne(id);
        if (usr != null) {
            usr.setUpdated(new Date());
            usr.setUpdatedBy(sysUser);
            userRepo.save(usr);
            return JSonUtil.toPrettyPrint(JSonUtil.mergeJSON(JSonUtil.msgJSON(ErrorCode.E000, id), JSonUtil.toJSON(usr, "Public")));
        } else {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E003, id));
        }
    }
}

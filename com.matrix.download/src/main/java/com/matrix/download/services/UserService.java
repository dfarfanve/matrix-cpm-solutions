
package com.matrix.download.services;

import com.matrix.download.model.User;
import java.util.Date;

public interface UserService {  
    
    public String findUser(long id, long sysUser);
    public String createUser(User usr,String email, Date datOfBirth);
    public String updateUser(long id, long sysUser, String usrName,String usrPass, String email, Date dateOfBirth);
    public String activeUser(long id,long sysUser, String active);
    public void setLoginUser(long id); 
    public String validateUser(String user, String password, String chain);
    
}

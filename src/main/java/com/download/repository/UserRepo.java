
package com.download.repository;

import com.download.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends CrudRepository<User,Integer>{
    
    @Query("SELECT  u FROM User u WHERE u.userName = ?1  ")
    User findByUserName(String userName);
    
    @Query("SELECT  u FROM User u WHERE u.clientId = ?1  ")
    User findByClientId(int clientId);
}

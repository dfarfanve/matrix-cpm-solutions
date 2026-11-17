package com.download.repository;

import com.download.model.Url;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UrlRepo extends CrudRepository<Url, Integer> {

    @Query("SELECT  u FROM Url u WHERE u.chainId = ?1 AND urlType='LOGIN'  ")
    Url findLoginUrl(int chainId);

    @Query("SELECT  u FROM Url u WHERE u.chainId = ?1 ORDER BY u.sequence")
    List<Url> findAllUrl(int chainId);
    
    @Query("SELECT  u FROM Url u WHERE u.chainId = ?1 AND u.sequence = ?2 ")
    Url getNextFromCurrent(int chainId,int seq);
}

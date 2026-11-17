
package com.download.repository;

import com.download.model.Parameter;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ParameterRepo extends CrudRepository<Parameter,Integer>{
    
    @Query("SELECT  u FROM Parameter u WHERE u.urlId = ?1 ")
    List<Parameter> findAllParametersFromUrl(int urlId);
}

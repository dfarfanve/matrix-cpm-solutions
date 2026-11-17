
package com.download.repository;

import com.download.model.DimCadenas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DimCadenasRepo extends CrudRepository<DimCadenas,Integer>{ 
}





package com.download.repository;

import com.download.model.DimClienteCadena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DimClienteCadenasRepo extends CrudRepository<DimClienteCadena,Integer>{ 
}




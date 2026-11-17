package com.download.repository;

import com.download.model.Property;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PropertyRepo extends CrudRepository<Property, Integer> {

    @Query("SELECT  p FROM Property p WHERE p.urlId = ?1 ")
    List<Property> findAllPropertyFromUrl(int urlId);
}

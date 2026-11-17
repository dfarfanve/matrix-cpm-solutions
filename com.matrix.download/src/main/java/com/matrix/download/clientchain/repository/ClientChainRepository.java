
package com.matrix.download.clientchain.repository;

import com.matrix.download.model.ClientChain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientChainRepository extends CrudRepository<ClientChain,Long>{
   
 
 ClientChain getChainClientResult(long chainId, int clientId, long basesId, int tipoId);
 
 @Query("SELECT IFNULL(MAX(d.cadena_id),0) FROM ClientChain d WHERE d.clientes_id=?1 ")
 int getMaxCadenaId(int clientId);
 
  @Query("SELECT IFNULL(MAX(d.bases_id),0) FROM ClientChain d WHERE d.clientes_id=?1 ")
 int getMaxBaseId(int clientId);
 
  @Query("SELECT IFNULL((MAX(d.tipo_id),0) FROM ClientChain d WHERE d.clientes_id=?1 ")
 int getMaxTipoId(int clientId);
}


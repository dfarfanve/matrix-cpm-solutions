package com.download.service;

import com.download.model.DimClienteCadena;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.download.repository.DimClienteCadenasRepo;

@Service
public class GetChainClientResultService  {

    @PersistenceContext
    EntityManager em;

    @Autowired
    DimClienteCadenasRepo ccrepo;

    public String getChainClientResult(int chainId, int clientId, int basesId, int tipoId) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from dimclientecadena where clientes_id=").append(clientId);
        if (chainId != 0) {
            sb.append(" and cadena_id=").append(chainId);
        }

        if (basesId != 0) {
            sb.append(" and bases_id=").append(basesId);
        }

        if (tipoId != 0) {
            sb.append(" and tipo_id=").append(tipoId);
        }
        sb.append(" order by fecha_fin desc");

        Query q = em.createNativeQuery(sb.toString(), DimClienteCadena.class);
        DimClienteCadena cc = null;
        List results = q.getResultList();
        if (!results.isEmpty()) {
            cc = (DimClienteCadena) results.get(0);
        }
        if(cc!=null)
        return JSonUtil.toPrettyPrint(JSonUtil.mergeJSON(JSonUtil.msgJSON(ErrorCode.E000, 0), JSonUtil.toJSON(cc, "Public")));
        else 
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E011, 0));
        
    }

}

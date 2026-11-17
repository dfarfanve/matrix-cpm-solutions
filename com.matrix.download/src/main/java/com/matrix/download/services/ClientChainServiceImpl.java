package com.matrix.download.services;

import com.matrix.download.clientchain.repository.ClientChainRepository;
import com.matrix.download.model.ClientChain;
import com.matrix.download.util.ErrorCode;
import com.matrix.download.util.JSonUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientChainServiceImpl implements ClientChainService {

    @Autowired
    ClientChainRepository repo;
    EntityManager em;

    @Override
    public String createClientChain(ClientChain cc) {
        repo.save(cc);
        return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, 0));
    }

    @Override
    public String getClientChain(long chainId, int clientId, long basesId, int tipoId) {

        String sqlQuery = "select * from dimclientecadena";
        Query q = em.createNativeQuery(sqlQuery, ClientChain.class);
        List results = q.getResultList();
        ClientChain cc=null;
        if (!results.isEmpty()) {
            cc = (ClientChain) results.get(0);
        }
        if(cc!=null)
            return JSonUtil.toPrettyPrint(JSonUtil.mergeJSON(JSonUtil.msgJSON(ErrorCode.E000, 0), JSonUtil.toJSON(cc, "Public")));
        else
            return 
    }
}

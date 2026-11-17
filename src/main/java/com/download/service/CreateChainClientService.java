package com.download.service;

import com.download.model.DimClienteCadena;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.download.repository.DimClienteCadenasRepo;

@Service
public class CreateChainClientService  {

    @Autowired
    DimClienteCadenasRepo ccrepo;

    public String createChainClient(DimClienteCadena cc) {
        ccrepo.save(cc);
        return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, 0));
    }
}

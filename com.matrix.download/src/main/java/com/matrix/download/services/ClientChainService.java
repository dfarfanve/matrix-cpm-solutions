package com.matrix.download.services;

import com.matrix.download.model.ClientChain;

public interface ClientChainService {

    public String getClientChain(long chainId, int clientId, long basesId, int tipoId);

    public String createClientChain(ClientChain cc);

}

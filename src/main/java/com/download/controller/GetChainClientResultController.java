package com.download.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.download.service.GetChainClientResultService;
import com.download.repository.DimClienteCadenasRepo;

@RestController
public class GetChainClientResultController {

    @Autowired
    GetChainClientResultService ccservice;

    @Autowired
    DimClienteCadenasRepo repo;

    @RequestMapping(value = "/getchainclientresult", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getchainclientresult(
            @RequestHeader(value = "clientes_id", required = true) int clientes_id,
            @RequestHeader(value = "cadena_id", required = false, defaultValue = "0") int cadena_id,
            @RequestHeader(value = "bases_id", required = false, defaultValue = "0") int bases_id,
            @RequestHeader(value = "tipo_id", required = false, defaultValue = "0") int tipo_id
    ) {
        return ccservice.getChainClientResult(cadena_id, clientes_id, bases_id, tipo_id);

    }
}

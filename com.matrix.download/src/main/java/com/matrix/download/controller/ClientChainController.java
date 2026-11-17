package com.matrix.download.controller;

import com.matrix.download.model.ClientChain;
import com.matrix.download.services.ClientChainService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.matrix.download.util.MatrixUtil;

@RestController
public class ClientChainController {

    

    @Autowired
    ClientChainService clientChainService;

    
    @RequestMapping(value = "/getchainclientresult", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getchainclientresult(
            @RequestHeader(value = "cadena_id", required = true) Long id,
            @RequestHeader(value = "clientes_id", required = true) int cid,
            @RequestHeader(value = "bases_id", required = true) Long bid,
            @RequestHeader(value = "tipo_id", required = true) int tid
            ) {
        return clientChainService.getClientChain(id, cid, bid, tid);

    }

    // CREATE
    @RequestMapping(value = "/createchainclientresult", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
   String createchainclientresult(
            @RequestHeader(value = "cadena_id", required = true) long cadena_id,
            @RequestHeader(value = "clientes_id", required = true) int clientes_id,
            @RequestHeader(value = "bases_id", required = true) int bases_id,
            @RequestHeader(value = "tipo_id", required = true) int tipo_id,
            @RequestHeader(value = "cadena_nombre", required = false ) String cadena_nombre,
            @RequestHeader(value = "clientes_nombre", required = false) String clientes_nombre,
            @RequestHeader(value = "bases_nombre", required = false) String bases_nombre,
            @RequestHeader(value = "dwh", required = false) String dwh,
            @RequestHeader(value = "mes_inicio", required = false, defaultValue="0") int mes_inicio,
            @RequestHeader(value = "mes_fin", required = false, defaultValue="0") int mes_fin,
            @RequestHeader(value = "mesWM_inicio", required = false, defaultValue="0") int mesWM_inicio,
            @RequestHeader(value = "mesWM_fin", required = false, defaultValue="0") int mesWM_fin,
            @RequestHeader(value = "semana_inicio", required = false, defaultValue="0") int semana_inicio,
            @RequestHeader(value = "semana_fin", required = false, defaultValue="0") int semana_fin,
            @RequestHeader(value = "semanaWM_inicio", required = false, defaultValue="0") int semanaWM_inicio,
            @RequestHeader(value = "semanaWM_fin", required = false, defaultValue="0") int semanaWM_fin,
            @RequestHeader(value = "semana_cerrada", required = false, defaultValue="0") int semana_cerrada,
            @RequestHeader(value = "fecha_inicio", required = false) Date fecha_inicio,
            @RequestHeader(value = "fecha_fin", required = false) Date fecha_fin,
            @RequestHeader(value = "proceso_activo", required = false, defaultValue="0") int proceso_activo,
            @RequestHeader(value = "proceso_activo_interno", required = false, defaultValue="0") int proceso_activo_interno,
            @RequestHeader(value = "pass_activo", required = false, defaultValue="0") int pass_activo) {
        ClientChain cc = new ClientChain();
        cc.setCadena_id(cadena_id);
        cc.setClientes_id(clientes_id);
        cc.setBases_id(cadena_id);
        cc.setTipo_id(tipo_id);
        cc.setCadena_nombre(cadena_nombre);
        cc.setBases_nombre(bases_nombre);
        cc.setDwh(dwh);
        cc.setMes_inicio(mes_inicio);
        cc.setMes_fin(mes_fin);
        cc.setMesWM_inicio(mesWM_inicio);
        cc.setMesWM_fin(mesWM_fin);
        cc.setSemana_inicio(semana_inicio);
        cc.setSemana_fin(semana_fin);
        cc.setSemanaWM_inicio(semanaWM_inicio);
        cc.setSemanaWM_fin(semanaWM_fin);
        cc.setSemana_cerrada(semana_cerrada);
        if(fecha_inicio!=null)
            cc.setFecha_inicio(fecha_inicio);
        else
            cc.setFecha_inicio(MatrixUtil.StringtoDate("01-01-1970"));
        
        if(fecha_fin!=null)
            cc.setFecha_fin(MatrixUtil.StringtoDate("01-01-1970"));
        else
         cc.setFecha_fin(fecha_fin);
        cc.setProceso_activo(proceso_activo);
        cc.setProceso_activo_interno(proceso_activo_interno);
        cc.setPass_activo(pass_activo);
        return clientChainService.createClientChain(cc);
    }

}

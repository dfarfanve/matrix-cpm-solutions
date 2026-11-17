package com.download.controller;

import com.download.service.DownloadClientService;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadClientController {

    @Autowired
    DownloadClientService dcs;

    @RequestMapping(value = "/downloadclient", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public String downloadtest(
            @RequestHeader(value = "clientId", required = true) int clientId,
            @RequestHeader(value = "initialdate", required = false) Date initialdate,
            @RequestHeader(value = "finaldate", required = false) Date finaldate,
            @RequestHeader(value = "filetype", required = false) String filetype) throws InterruptedException, ExecutionException {
        return dcs.downloadClient(clientId, initialdate, finaldate, filetype);
    }
}

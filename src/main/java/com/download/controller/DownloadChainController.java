package com.download.controller;

import com.download.service.DownloadChainService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadChainController {

    @Autowired
    DownloadChainService downloadService;

    @RequestMapping(value = "/downloadchain", method = {RequestMethod.POST}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String downloadchain(
            @RequestHeader(value = "clientId", required = true) int id,
            @RequestHeader(value = "chainname", required = true) String chainName,
            @RequestHeader(value = "initialdate", required = true) Date initialdate,
            @RequestHeader(value = "finaldate", required = false) Date finaldate,
            @RequestHeader(value = "filetype", required = false) String filetype) {
        return downloadService.downloadChain(id, chainName, initialdate, finaldate, filetype);
    }
}

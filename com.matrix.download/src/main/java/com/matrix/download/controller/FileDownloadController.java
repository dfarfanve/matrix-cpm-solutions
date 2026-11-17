package com.matrix.download.controller;

import com.matrix.download.services.DownloadService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
 
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class FileDownloadController {
     
  
     @Autowired
    DownloadService downloadService;
    @RequestMapping(value = "/downloadchain", method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String downloadchain(
            @RequestHeader(value="clientid", required=true) long id,
            @RequestHeader(value="chainname",  required=true) String chainName,
            @RequestHeader(value="initialdate",  required=true) Date initialdate,
            @RequestHeader(value="finaldate",  required=false) Date finaldate,
            @RequestHeader(value="filetype",  required=true) String filetype)
    { 
    return downloadService.downloadchain(id, chainName, initialdate,finaldate,filetype);
    }  
    

 
    
}

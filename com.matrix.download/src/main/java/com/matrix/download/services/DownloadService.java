
package com.matrix.download.services;

import java.util.Date;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;



public interface DownloadService {  
    
  public @ResponseBody String downloadchain(long id, String chainName, Date startdate,Date enddate,String filetype);
    public @ResponseBody String downloadchainstatus(long id, String url);
    
}

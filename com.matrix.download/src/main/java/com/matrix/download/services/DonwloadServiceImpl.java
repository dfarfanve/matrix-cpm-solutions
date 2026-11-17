package com.matrix.download.services;

import com.matrix.download.util.ErrorCode;
import com.matrix.download.util.JSonUtil;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class DonwloadServiceImpl implements DownloadService {

    @Override
    public String downloadchain(long id, String chainName, Date startdate,Date enddate,String filetype) {
        
       return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
    }

    @Override
    public String downloadchainstatus(long id, String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

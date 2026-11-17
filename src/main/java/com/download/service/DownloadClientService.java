package com.download.service;

import com.download.component.AsyncDownloadComponent;
import com.download.component.AsyncProvecomerComponent;
import com.download.model.User;
import com.download.repository.UserRepo;
import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadClientService {

    @Autowired
    UserRepo ur;

    @Autowired
    AsyncDownloadComponent adc;

    @Autowired
    AsyncProvecomerComponent apc;

    public String downloadClient(int clientId, Date startDate, Date endDate, String fileType) {
        Future<String> asyncResult = adc.startAsynDownloadClientTask(clientId);
        callAsyncClassFromClient(clientId,startDate,endDate,fileType);
        while (!asyncResult.isDone()) {
            return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, clientId));
        }
        return null;
    }

    public void callAsyncClassFromClient(int clientId,Date startDate, Date endDate, String fileType) {
        try {
            User usr = ur.findByClientId(clientId);
            if (usr != null) {
                switch (usr.getChainId()) {
                    case 4:
                        apc.AsyncProvecomerClientDownload(usr,startDate,endDate,fileType);
                        break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DownloadClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}    


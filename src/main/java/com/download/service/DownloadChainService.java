package com.download.service;

import com.download.util.ErrorCode;
import com.download.util.JSonUtil;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DownloadChainService {

    public String downloadChain(int id, String chainName, Date startdate, Date enddate, String filetype) {
        return JSonUtil.toPrettyPrint(JSonUtil.msgJSON(ErrorCode.E000, id));
    }
}

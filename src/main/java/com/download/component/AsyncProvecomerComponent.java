package com.download.component;

import com.google.common.base.Stopwatch;
import com.download.model.Parameter;
import com.download.provecomer.Provecomer;
import com.download.model.User;
import com.download.provecomer.KettleProcess;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.download.repository.ParameterRepo;
import com.download.repository.UserRepo;
import com.download.util.HttpUtil;
import java.util.Date;

@Component
public class AsyncProvecomerComponent {

    private static final Logger logger = LoggerFactory.getLogger(AsyncProvecomerComponent.class);

    @Autowired
    UserRepo ur;

    @Autowired
    ParameterRepo pr;

    @Async
    public void AsyncProvecomerClientDownload(User usr, Date startDate, Date endDate, String fileType) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        logger.info("AsyncProvecomerClientDownload task starting");

        Thread.sleep(5000);

        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        if (usr != null) {
            List<Parameter> paramList = pr.findAllParametersFromUrl(1);
            //TODO hacer recursivo el llamado a las cadenas
            Provecomer pcm = new Provecomer(usr, paramList);
            KettleProcess kp = new KettleProcess(4,60);
            //END TODO
            
            //TODO hacer llamado al servicio patch leyendo de las rutas
            HttpUtil notif = new HttpUtil();
            //notif.patch("54.224.104.142:9888/privateapi/clientchain","");
            //END TODO
            
//                String id = ProvecomerUtil.executeJob(pcmUser.getChainId());
//                xmlResponse = ProvecomerUtil.jobStatus(id);
//               if ("Finished".equalsIgnoreCase(xmlResponse)){
//                    System.out.println(ProvecomerUtil.getGoodBodyPatch(pcmUser.getClientName(),pcmUser.getChainName())); 
//                }
//                if("ERROR".equalsIgnoreCase(xmlResponse)) {
//                    System.out.println(ProvecomerUtil.getBadBodyPatch(pcmUser.getClientName(),pcmUser.getChainName(),"E011")); 
//                }    

            logger.info("AsyncProvecomerClientDownload task completed in " + stopwatch);

        }
    }
}

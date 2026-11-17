package com.download.component;

import com.google.common.base.Stopwatch;
import com.download.model.Parameter;
import com.download.provecomer.Provecomer;
import com.download.model.User;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.logging.Level;

@Component
public class AsyncDownloadComponent {

    private static final Logger logger = LoggerFactory.getLogger(AsyncDownloadComponent.class);

    @Async
    public Future<String> startAsynDownloadClientTask(int clientId) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            logger.info("startAsynDownloadTask - Client :" + clientId + " starting");
            Thread.sleep(5000);
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(AsyncDownloadComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("Done");
    }
    
    @Async
    public Future<String> startAsynDownloadChainTask(int clientId) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            logger.info("startAsynDownloadChainTask - Client :" + clientId + " starting");
            Thread.sleep(5000);
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(AsyncDownloadComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("Done");
    }
}

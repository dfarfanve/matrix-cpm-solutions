package com.matrix.download.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.util.Timer;
import java.util.TimerTask;

class TimerEx {
    public static void main(String arglist[]) {
    Timer timer;
    timer = new Timer();

    TimerTask task = new TimerTask() {
        int tic=0;

        @Override
        public void run()
        {
            if (tic%2==0)
            System.out.println("TIC");
            else
            System.out.println("TOC");
            tic++;
            if(tic==10)
                timer.cancel();
        }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
    timer.schedule(task, 10, 1000);
    }
}

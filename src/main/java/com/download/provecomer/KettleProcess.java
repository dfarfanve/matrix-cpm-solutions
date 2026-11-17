package com.download.provecomer;

import com.download.util.HttpUtil;
import com.download.util.XMLUtil;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class KettleProcess {

    String startUrl = "http://localhost:8089/kettle/executeJob/?job=D:\\websinergia\\PDI\\Job_Procesamiento.kjb&VarIdCadena=";
    String endUrl = "http://localhost:8089/kettle/jobStatus/?name=D:\\websinergia\\PDI\\Job_Procesamiento.kjb&xml=Y&id=";
    String user = "cluster";
    String pass = "cluster";
    String xmlContent;
    URLConnection uc;
    String status;

    public  KettleProcess(int chainId, int taskSeconds) {
        startUrl += chainId;
        uc = HttpUtil.getBasicAuthConnection(startUrl, user, pass);
        xmlContent = HttpUtil.getConnectionContent(uc);
        endUrl += KettleProcess.getValueFromXml(xmlContent, "webresult", "id");
        System.out.println(endUrl);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                uc = HttpUtil.getBasicAuthConnection(endUrl, user, pass);
                xmlContent = HttpUtil.getConnectionContent(uc);
                status = KettleProcess.getValueFromXml(xmlContent, "jobstatus", "status_desc");
                System.out.println(uc); 
                System.out.println(status);
                if ("Finished".equalsIgnoreCase(status) || "ERROR".equalsIgnoreCase(status)) {
                   
                    timer.cancel();
                }
            }
        };
        // Empieza  dentro de 1 ms y repite la tarea cada 60 s o 60000 ms
        timer.scheduleAtFixedRate(task, 1, TimeUnit.SECONDS.toMillis(taskSeconds));
    }

    public static String getValueFromXml(String xml, String nodeElementName, String elementName) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(xml)));
            NodeList nList = doc.getElementsByTagName(nodeElementName);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    return eElement.getElementsByTagName(elementName).item(0).getTextContent();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

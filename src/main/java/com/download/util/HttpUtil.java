package com.download.util;

import com.download.model.Parameter;
import com.download.model.Property;
import com.download.provecomer.ProvecomerScrapping;
import com.download.provecomer.ProvecomerUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.util.Base64;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class HttpUtil {

    /**
     * 
     * @param user
     * @param password
     * @param url
     * @param paramList
     * @return 
     */
    public static String buildLoginUrl(String user, String password, String url, List<Parameter> paramList) {

        StringBuilder sb = new StringBuilder(url);
        int i = 0;
        for (Parameter param : paramList) {
            if (i == 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            if ("VARIABLE".equalsIgnoreCase(param.getParamType())) {
                if ("USER".equalsIgnoreCase(param.getParamRef())) {
                    sb.append(param.getParamName()).append("=").append(user);
                }
                if ("PASS".equalsIgnoreCase(param.getParamRef())) {
                    sb.append(param.getParamName()).append("=").append(password);
                }
            } else if ("CONSTANTE".equalsIgnoreCase(param.getParamType())) {
                sb.append(param.getParamName()).append("=").append(param.getParamValue());
            }
            i++;
        }
        return sb.toString();
    }
    /**
     * 
     * @param url
     * @param propertiesList
     * @return 
     */
    public static String getHtmlFromUrl(String url, List<Property> propertiesList) {
        try {
            String inputLine;
            StringBuilder sb = new StringBuilder();
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            for (Property oneProperty : propertiesList) {
                if ("CONSTANTE".equalsIgnoreCase(oneProperty.getType())) {
                    con.setRequestProperty(oneProperty.getName(), oneProperty.getValue());
                }
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }   in.close();
           return sb.toString();
        } catch (MalformedURLException ex ) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static URLConnection getBasicAuthConnection(String url, String name, String password) {
        try {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, "Connecting to URL = " + url, url);
            String authString = name + ":" + password;
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            return urlConnection;
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getConnectionContent(URLConnection conn) {
        try {
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            return sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int getConnectionStatus(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        return response.statusCode();
    }

    public static void saveXMLFile(URLConnection conn, String xmlName) {
        try {
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fout = new FileOutputStream(xmlName + ".xml");
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void saveFile(final String urlString) {
        try {
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            URL obj = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36");

            try {
                in = new BufferedInputStream(conn.getInputStream());
                fout = new FileOutputStream("D:\\websinegia\\Comercial\\Data\\" + FilenameUtils.getName(obj.getPath()));
                final byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
            } catch (IOException ex) {
                Logger.getLogger(HttpUtil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                return;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return;
        }
    }

    public static void patch(String url, String jo) throws IOException {
        HttpResponse response = null;
        BufferedReader rd = null;
        StringBuffer result = new StringBuffer();
        String line = "";

        HttpClient httpclient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(url);

        try {
            //Execute and get the response.

            StringEntity params = new StringEntity(jo);

            params.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPatch.setEntity(params);

            response = httpclient.execute(httpPatch);

            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                result.append(line);
            }

        } catch (Exception e) {

        }
    }

}

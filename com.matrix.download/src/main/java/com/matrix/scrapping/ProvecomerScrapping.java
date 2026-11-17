package com.matrix.scrapping;

import com.matrix.download.HttpUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProvecomerScrapping {

    List<HttpCookie> cookies;
    private String cookie;
    public static CookieManager manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);

    public static void main(String args[]) throws Exception {
        ProvecomerScrapping ps = new ProvecomerScrapping();
        String urllogin ="http://www.proveccm.com/webPrvd/LoginProvecomerNpSrv";
        String urlinicial = "http://www.proveccm.com/webPrvd/LoginProvecomerNpSrv?proveedor=152239&password=G614G451&enviar1=enviar1&enviar1.x=29&enviar1.y=6";
        String referer0 = "http://www.proveccm.com/jspProvecomer/provecomerNp/Menu.jsp?megrId=14&megrIdAnt=0";
        String referer1 = "http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv?menuId=157";
//        String referer2 = "http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv?repoStore=PRVD_DESC_REP.ufn_pvr_descarga05&repoPool=Provee&repoPoolval=Provee&repoDes=Confirmaci%F3n@de@descarga@de@informaci%F3n&repoNcol=8&repoId=1612&noCapturaDatosC=0&noCapturaDatos=1&liga=true&grafica=0&repoStoval=PRVD_DESC_REP.ufn_pvs_descarga05&repoRetro=0&repoDinamico=false&repoNwinS=0&repoAyuda1S=ndf&campo0=15%3A20170207%3A0&repaTipdato0=2&generaReporteDosB.x=true&menuId=158&banderaPerm=false&repoTipo=1";
//        String urlfinal = "http://www.proveccm.com/vtainv/DEVO201702070_152239_332121.txt.gz";
        String uri1="http://www.proveccm.com";
        String uri2="http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv";

        if (HttpUtils.getConnectionStatus(urllogin)==200) {
            ps.getConnection(urlinicial, null);

            Document doc = ps.GetPageContent(referer1, referer0,uri2);
            
            // get all links in page
            Elements links = doc.select("a[href]");
            System.out.println(links);
            for (Element link : links) {
                // get the value from the href attribute

                if (link.attr("href").startsWith("?repoStore")) {
                    Document doc2 = ps.GetPageContent(link.attr("abs:href"), referer1,uri1);//HttpUtils.getHtmlDocument(link.attr("abs:href"), cookie);
                     
                    Elements hlinks = doc2.select("a[href]");
                    for (Element link2 : hlinks) {
                        if (link2.attr("href").startsWith("/vtainv")) 
                        ps.saveFile(link2.attr("abs:href"), link.attr("abs:href"));
                        }
            }
                 
        }
    }
    }

    private Document GetPageContent(String url, String referer, String uri) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Host", "www.proveccm.com");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Upgrade-Insecure-Request", "1");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36");
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
        conn.setRequestProperty("Accept-Language", "es-419,es;q=0.8");
        if (cookie != null) 
            conn.setRequestProperty("Cookie", cookie);
        if (referer != null) 
            conn.setRequestProperty("Referer", referer);
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        if(response!=null)
            return Jsoup.parse(response.toString(),uri);
        return null;
    }

    public void saveFile(final String urlString, String referer) 
             {
        try {
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            URL obj = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Host", "www.proveccm.com");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Upgrade-Insecure-Request", "1");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept-Language", "es-419,es;q=0.8");
            if (cookie != null) {
                conn.setRequestProperty("Cookie", cookie);
                
            }
            if (referer != null) {
                conn.setRequestProperty("Referer", referer);
            }
            
            try {
                in = new BufferedInputStream(conn.getInputStream());
                fout = new FileOutputStream(FilenameUtils.getName(obj.getPath()));
                final byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
            } catch (IOException ex) {
                Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                return;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return;
        }
    }
    public HttpURLConnection getConnection(String url, String referer) throws ProtocolException, MalformedURLException, IOException{
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Host", "www.proveccm.com");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Upgrade-Insecure-Request", "1");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36");
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
        conn.setRequestProperty("Accept-Language", "es-419,es;q=0.8");
        if (cookie != null) {
            conn.setRequestProperty("Cookie", cookie);

        }
        if (referer != null) {
            conn.setRequestProperty("Referer", referer);
        }
        if (cookie == null) {
            cookie = conn.getHeaderField("Set-Cookie");
        }
        return conn;
    }
    public String getCookies() {
        return cookie;
    }

    public void setCookies(String c) {
        this.cookie = c;
    }
}

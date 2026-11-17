package com.download.provecomer;

import com.download.model.Parameter;
import com.download.model.Property;
import com.download.model.Url;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import com.download.repository.ParameterRepo;
import com.download.repository.PropertyRepo;
import com.download.repository.UrlRepo;

public class ProvecomerScrapping {

    List<Property> propertiesList;
    private String cookie;
    Url tmp;
    List<Url> urlList;

    public static CookieManager manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);

    @Autowired
    UrlRepo urlRepo;

    @Autowired
    ParameterRepo paramRepo;

    @Autowired
    PropertyRepo propertyRepo;

    public ProvecomerScrapping() {
        provecomerDownload(1);
    }

    private void provecomerDownload(int chainId) {
        urlList.add(urlRepo.findLoginUrl(chainId));
        int iterator = 0;
        Document htmlDoc;
        Elements links;
        Url urlObj;
        while (iterator < urlList.size()) {
            tmp = urlList.get(iterator);
            switch (tmp.getUrlType()) {
                case "LOGIN":
                    if (getConnectionStatus(tmp) == 200) {
                        tmp.setUrlStr(buildUrlWithParams(null, null, tmp));
                        getSesionProperties(tmp);
                        urlList.add(urlRepo.getNextFromCurrent(chainId, tmp.getNext()));
                    }
                    break;

                case "SCRAPPING":

                    htmlDoc = GetPageContent(tmp);
                    links = htmlDoc.select("a[href]");
                    
                    for (Element link : links) {
                        if (link.attr("href").startsWith(tmp.getUrlHRef())) {
                            urlObj = urlRepo.getNextFromCurrent(tmp.getChainId(), tmp.getNext());
                            urlObj.setUrlStr(link.attr("abs:href"));
                            urlList.add(urlObj);
                        }
                    }
                    break;

                case "DOWNLOAD":
                    saveFile(tmp);
                    break;
            }
        }
        iterator++;
    }

    private Document GetPageContent(Url url) {
        try {
            URL obj = new URL(url.getUrlStr());
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            for (Property proper : propertiesList) {
                conn.setRequestProperty(proper.getName(), proper.getValue());
            }
            if (cookie != null) {
                conn.setRequestProperty("Cookie", cookie);
            }
            if (url.getUrlHRef() != null) {
                conn.setRequestProperty("Referer", url.getUrlHRef());
            }
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            if (response != null) {
                return Jsoup.parse(response.toString(), url.getParseUri());

            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void saveFile(Url url) {
        try {
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            URL obj = new URL(url.getUrlStr());
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            for (Property proper : propertiesList) {
                conn.setRequestProperty(proper.getName(), proper.getValue());
            }
            if (cookie != null) {
                conn.setRequestProperty("Cookie", cookie);
            }
            if (url.getUrlHRef() != null) {
                conn.setRequestProperty("Referer", url.getUrlRef());
            }

            try {
                in = new BufferedInputStream(conn.getInputStream());
                fout = new FileOutputStream(FilenameUtils.getName(obj.getPath()));
                final byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (fout != null) {
                    fout.close();

                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HttpURLConnection getConnection(String url, String referer) throws ProtocolException, MalformedURLException, IOException {
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

    private int getConnectionStatus(Url url) {
        try {
            Connection.Response response = Jsoup.connect(url.getUrlStr()).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
            return response.statusCode();

        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private String buildUrlWithParams(String user, String password, Url url) {
        StringBuilder sb = new StringBuilder(url.getUrlStr());
        List<Parameter> paramList = paramRepo.findAllParametersFromUrl(url.getUrlId());
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
                    //sb.append(param.getParamName()).append("=").append(PabisCrypto.decrypt(password, "private.der"));
                    sb.append(param.getParamName()).append("=").append(password);
                }
            } else if ("CONSTANTE".equalsIgnoreCase(param.getParamType())) {
                sb.append(param.getParamName()).append("=").append(param.getParamValue());
            }
            i++;
        }
        return sb.toString();
    }

    private void getSesionProperties(Url url) {
        try {
            URL obj = new URL(url.getUrlStr());
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            propertiesList = propertyRepo.findAllPropertyFromUrl(url.getUrlId());
            for (Property proper : propertiesList) {
                if ("CONSTANTE".equalsIgnoreCase(proper.getType())) {
                    conn.setRequestProperty(proper.getName(), proper.getValue());
                }
            }
            cookie = conn.getHeaderField("Set-Cookie");

        } catch (MalformedURLException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ProvecomerScrapping.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}

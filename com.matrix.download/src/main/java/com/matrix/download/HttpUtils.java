package com.matrix.download;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HttpUtils {

    private List<String> cookies;
    private HttpURLConnection conn;

    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36";

    public static void main(String[] args) throws Exception {

        saveFile("http://www.proveccm.com//vtainv/DEVO201702080_152239_334122.txt.gz", null);
        
    }

    public static int getConnectionStatus(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        return response.statusCode();
    }

    
    public static Document getCSVDocument(String url, String cookie) throws ProtocolException, MalformedURLException, IOException {
        Connection.Request con =  Jsoup.connect(url)
                .cookie("JSESSIONID", cookie)
                .ignoreContentType(true)
                .request();
  
        System.out.println(con.toString());
//        con.addRequestProperty("Cookie", "JSESSIONID=" + cookie + ";");
//        con.addRequestProperty("User-Agent", "Mozilla/5.0");
//        System.out.println("Cookie: " + con.getHeaderField("Cookie"));
//        System.out.println("Content type: " + con.getContentType());
//        System.out.println("User-Agent: " + con.getHeaderField("User-Agent"));
//        InputStream in = con.getInputStream(); // save file
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        String inputLine;
//        while ((inputLine = br.readLine()) != null) {
//            System.out.println(inputLine);
//        }
//        in.close();
        return null;
    }

    public static void sendPost(String url, String cookie) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("JSESSIONID", cookie);
        //conn.connect();
        try ( // Enviar solicitud POST
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            //wr.writeBytes(postParams);
            wr.flush();
        } catch (EOFException eof) {
            eof.printStackTrace();
        }
        BufferedReader in
                = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

    }

    public static Map<String, String> getCookie(String url) throws MalformedURLException, IOException {

        Connection.Response res = Jsoup.connect(url)
                .data("proveedor", "152239")
                .data("password", "G614G451")
                .data("enviar1", "enviar1")
                .data("enviar1.x", "60")
                .data("enviar1.y", "5")
                .method(Method.POST)
                .execute();

        return res.headers();
    }

    public static void saveFile(final String urlString, final String cookie)
            throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
      
        try {
            in = new BufferedInputStream(con.getInputStream());
            fout = new FileOutputStream(FilenameUtils.getName(url.getPath()));
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
    }

    public static void downloadfile(String url, String cookie) throws MalformedURLException, IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        
        con.addRequestProperty("Cookie", "registration=Cooki_Value_Here;profile-data=Cookie_Value_Here");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

    public static String getUrlParams() throws UnsupportedEncodingException {

        List<String> paramList = new ArrayList<>();
        paramList.add("proveedor" + "=" + URLEncoder.encode("152239", "UTF-8"));
        paramList.add("password" + "=" + URLEncoder.encode("G614G451", "UTF-8"));
        paramList.add("enviar1" + "=" + URLEncoder.encode("enviar1", "UTF-8"));
        paramList.add("enviar1.x" + "=" + URLEncoder.encode(Integer.toString(60), "UTF-8"));
        paramList.add("enviar1.y" + "=" + URLEncoder.encode(Integer.toString(5), "UTF-8"));
        StringBuilder urlParams = new StringBuilder();
        for (String param : paramList) {
            if (urlParams.length() == 0) {
                urlParams.append("?").append(param);
            } else {
                urlParams.append("&").append(param);
            }
        }
        return urlParams.toString();
    }
    
    // HTTP POST request
	public static void  sendPost() throws Exception {


		String url = "http://www.proveccm.com/webPrvd/LoginProvecomerNpSrv?proveedor=152239&password=G614G451&enviar1=enviar1&enviar1.x=29&enviar1.y=6";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                String responsestr=response.toString();
		//print result
		System.out.println(response.toString());
                if(responsestr.contains(" Error en clave o contraseña !!!!!"))
                    System.out.println("true");
                else
                    System.out.println("false");

	}

	
}

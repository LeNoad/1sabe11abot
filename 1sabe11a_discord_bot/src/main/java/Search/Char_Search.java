package Search;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ServerAPI.ServerCode;
import ServerAPI.apiKey;

public class Char_Search {
    ServerCode serverCode = new ServerCode();
    apiKey apikey = new apiKey();
    charNameSearch search;
    String char_info;
    public String getUrl(String result,String serverNum){
        String url = "https://api.neople.co.kr/df/servers/"+serverCode.selectServer(serverNum)+"/characters?characterName="+encodeURIComponent(result)+"&apikey="+apikey.setapiKey();
        return url;
    }
    public static String encodeURIComponent(String component) {
        String result = null;
        try {
            result = URLEncoder.encode(component, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}

package Search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ServerAPI.ServerCode;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.text.*;

public class SearchTable {
    Document doc;
    Document doc2;
    String url;
    String dundamurl;
    public void search(String str, String i) {
        ServerCode serverCode = new ServerCode();
        Char_Search search = new Char_Search();
        charNameSearch charName = new charNameSearch();
        try {
            charName.charNameSearch(str,i);
            String rs = charName.charNameSearch(str,i);
            try {
				setSSL();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            url = "https://dundam.xyz/view40s?image="+rs+"&server="+serverCode.selectServer(i)+"&name="+str;
            System.out.println(str);
            dundamurl = "https://dundam.xyz/search?server="+serverCode.selectServer(i)+"&name="+search.encodeURIComponent(str);
            doc2 = Jsoup.connect(dundamurl).get();
            doc = Jsoup.connect(url).get();
            
            //https://dundam.xyz/view40s?image=6f67f17f1d1e1d840393a756a4fc0bbd&server=cain&name=%EB%B6%80%EC%96%91%EB%94%B8%EB%82%B4%EB%AF%B8&temp=5189
            //https://dundam.xyz/view?image=6f67f17f1d1e1d840393a756a4fc0bbd&server=cain&name=%EB%B6%80%EC%96%91%EB%94%B8%EB%82%B4%EB%AF%B8
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String get1sinergeDmgTable(int i) {
    	Element dundam_data = doc2.select("div.pid").get(0);
    	String data_Table = dundam_data.text();
    	String[] result = data_Table.split(" ");
    	String rs = result[1].replace(":", "");
    	return result[i];
    }
    public String getDmgTable(int i){
        Elements dmg = doc.select(".adamage");
        String dmgTable = dmg.text();
        String[] result = dmgTable.split(" ");
        return result[i];
    }
    public String getBuffTable(int i) {
        Elements buff = doc.select(".adamage");
        String buffTable = buff.text();
        String[] result = buffTable.split(" ");
        return result[i];
    }
    public String getRankTable(int i) {
        Elements rank = doc.select(".num");
        String rankTable = rank.text();
        String[] result = rankTable.split(" ");
        return result[i];
    }
    public String getThumbnail_URL(){
        return url;
    }
    public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
                        throws CertificateException {
                }
                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
                        throws CertificateException {
                }

            }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
}
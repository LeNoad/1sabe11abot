package Search;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class charNameSearch {
    public String charNameSearch(String nickName, String i) throws IOException {
        Char_Search search = new Char_Search();
        URL url = new URL(search.getUrl(nickName, i));
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        Scanner scan = new Scanner(is);
        String str = scan.nextLine();
        String[] result = str.split("\"");
//        for(i=0; i<result.length; i++) {
//            System.out.println(i+"번:"+result[i]);
//        }
//        int charSearchId = str.indexOf("characterId");
//        int charSearchName = str.indexOf("characterName");
//        String num = str.substring(str.indexOf("characterId")+14,str.indexOf("characterName")-3);
//        System.out.println(result[9]);
        return result[9];
    }
}
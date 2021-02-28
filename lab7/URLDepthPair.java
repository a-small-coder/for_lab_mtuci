package java_mtuci.lab7;
import java.net.*;

public class URLDepthPair {
    private String url;
    private int parseDeep;

    public URLDepthPair(String str, int num){
        url = str;
        parseDeep = num;
    }

    public String getUrl(){
        return url;
    }

    public int getParseDeep(){
        return parseDeep;
    }

    public String toString(){
        String str = Integer.toString(parseDeep) + ": " + url;
        return str;
    }
}

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class GetRequest {

    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {
        System.out.println(request("програмный интерфейс ПРИЛоЖЕНИЯ"));
    }

    public static String request(String str){

        CloseableHttpResponse resp1 = null;

        String reqStr = str.replace(' ', '+');
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=" + reqStr);
            resp1 = httpClient.execute(httpGet);

            return EntityUtils.toString(resp1.getEntity());
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        } finally {
            try {
                resp1.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}

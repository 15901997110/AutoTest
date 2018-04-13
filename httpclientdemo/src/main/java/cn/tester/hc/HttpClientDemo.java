package cn.tester.hc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;

public class HttpClientDemo {

    @Test
    public void dogetDemo() throws IOException {
        String result = null;
        HttpGet get = new HttpGet("http://www.baidu.com/");
        HttpClient client= HttpClients.createDefault();

        HttpResponse response = client.execute(get);
        HttpEntity httpEntity = response.getEntity();
        result= EntityUtils.toString(httpEntity);
        System.out.println(result);
    }
}

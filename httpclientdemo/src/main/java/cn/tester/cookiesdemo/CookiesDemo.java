package cn.tester.cookiesdemo;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CookiesDemo {
    private static String baseUrl=null;
    private static ResourceBundle bundle=null;
    private static CookieStore cookieStore=new BasicCookieStore();
    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        baseUrl=bundle.getString("base.url");
    }
    @Test
    public void doGetCookie() throws IOException {
        String getCookiesUri=bundle.getString("getCookies.uri");
       //HttpGet httpGet=new HttpGet(baseUrl+getCookiesUri);
        HttpGet httpGet=new HttpGet("http://www.hairongyi.com");

        //build时先定义一个CookieStore
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = client.execute(httpGet);

        //获取Cookie信息
        List<Cookie> cookies = cookieStore.getCookies();
        System.out.println("cookie个数:"+cookies.size());
        for(Cookie cookie : cookies){
            System.out.println("cookie名称:"+cookie.getName()+"    cookie值:"+cookie.getValue());
        }


        //获取响应实体内容
        HttpEntity responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity);
        System.out.println("1:"+result);
    }
    @Test(dependsOnMethods = "doGetCookie")//gogetCookie拿到cookie之后 ,这里再带着cookie去访问
    public void getHttp() throws IOException {
        String uri=bundle.getString("doGetCookie.uri");
        HttpGet get= new HttpGet(baseUrl+uri);
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println("2:"+result);
    }
}

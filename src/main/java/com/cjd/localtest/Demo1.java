package com.cjd.localtest;

//import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import javax.swing.text.html.parser.Entity;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        try{
            String url = "http://127.0.0.1";

            //HttpClient httpClient = null;
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();


            CloseableHttpResponse closeableHttpResponse = null;

            //HttpMethod httpMethod = new HttpGet(url);

            String str = "http://localhost:8080/get?id=SSP.sys.20190523165944822&page_no=1&page_size=10&param=%5B%7B%22query_sel%22%3A%22%22%2C%22curr_code%22%3A%22CNY%22%2C%22stats_dt%22%3A%2220200507%22%2C%22acct_acct%22%3A%22Z1067000000%22%2C%22acct_name%22%3A%22%E6%98%8A%E6%B3%B0%E7%9C%9F%E6%98%8A%E5%8D%97%E6%B2%B3%22%2C%22operator%22%3A%22XXQDCZY01%22%7D%5D&req_id=1588917428377320914&serial_id=1588917428377320914&sub_serial_id=GAPS000720054638760398087&sync_type=0";
            String str2 = "param=昊泰真昊南河";
            String str3 = "http://localhost:8080/get?" + str2;
            //HttpGet httpGet = new HttpGet(url + "?" + str);
            HttpGet httpGet = new HttpGet(str);

            List<String> pamar = new ArrayList<String>();
            pamar.add(str);

            //httpGet.setHeader("User-Agent","");

            //httpGet.setHeader("Referer",url);

            //closeableHttpResponse = closeableHttpClient.execute(httpGet);
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            //System.out.println(closeableHttpResponse);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            System.out.println("------------------------------------------");
            System.out.println(EntityUtils.toString(httpEntity));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

package com.qa.client;

import netscape.javascript.JSObject;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;

public class RestClient {

    // 1. GET method
    public void get(String url) throws ClientProtocolException, IOException {
        // CloseableHttpClient --> an abstract class
        // httpClient --> object ref variable
        // HttpClients --> class, this class contains createDefault() method

        CloseableHttpClient httpClient = HttpClients.createDefault(); // createDefault method established a client connection
        HttpGet httpget = new HttpGet(url); // http get request
        CloseableHttpResponse  closeableHttpResponse = httpClient.execute(httpget); // hit/execute get url - send button in postman and return response

        // a. Status code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode(); // get status line ok with status code 200 in the form of int
        System.out.println("Status code---->" + statusCode);

        // b. Response string

        // EntityUtil class has toString method which return response in complete string format
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ---->" + responseJson);

        // c. All headers
        Header[] headersArray = closeableHttpResponse.getAllHeaders();
        HashMap<String,String> allHeaders = new HashMap<String,String>();
        for(Header header: headersArray){
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Get all headers--->" + allHeaders );
    }
}

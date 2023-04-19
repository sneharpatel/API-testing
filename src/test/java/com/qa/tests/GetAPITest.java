package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAPITest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    String apiUrl;
    String url;
    RestClient restClient;

    @BeforeMethod
    public void setUp() throws IOException {
        testBase = new TestBase();
        serviceUrl = prop.getProperty("serviceURL"); // service url = Endpoint URL - have to pass exact key string
        apiUrl = prop.getProperty("apiURL"); // have to pass exact value string
        // https://reqres.in/api/users
        url = serviceUrl + apiUrl;
    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient(); // object of RestClient class to call get method
        restClient.get(url);
    }

}

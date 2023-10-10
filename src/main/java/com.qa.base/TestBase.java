// setting up CI-CD pipeline on Jenkins

package com.qa.base;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class TestBase {

    public Properties prop;

    //TestBase class constructor
    public TestBase() {
        try{
            // how to read properties file : https://www.youtube.com/watch?v=0XowYwfvbo8&ab_channel=NaveenAutomationLabs
            // https://stackoverflow.com/questions/2353057/how-to-convert-inputstream-to-fileinputstream
            prop = new Properties();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader(); //
            URL resource = classloader.getResource("config.properties");
            File file = new File(resource.toURI());
            FileInputStream input = new FileInputStream(file);
            prop.load(input);
            System.out.println(prop.getProperty("serviceURL"));
            System.out.println(prop.getProperty("apiURL"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

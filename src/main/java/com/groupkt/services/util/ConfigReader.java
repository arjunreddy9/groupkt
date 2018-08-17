package com.groupkt.services.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author amasthipur
 * Created on : 8/16/18
 */
public class ConfigReader {

    InputStream inputStream;
    String result;

    public String getServiceURL(String whichServiceEndPoint) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "services.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("propFileName " + "' not found in the " +
                        "classpath");
            }

            result = prop.get(whichServiceEndPoint).toString();

          } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
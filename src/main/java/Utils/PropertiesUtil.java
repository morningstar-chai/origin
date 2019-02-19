package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    Properties properties;

    public PropertiesUtil(String propFilePath){
        properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try{
            InputStream resourceStream = loader.getResourceAsStream(propFilePath);
            properties.load(resourceStream);
            resourceStream.close();

        }catch(IOException e){
            System.out.println(e);
        }
    }
    public String getProperty(String propertyKey){
        String propertyValue = properties.getProperty(propertyKey);

        return propertyValue;
    }
}

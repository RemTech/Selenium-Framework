package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigCode {
    // This class is for configurations
   private String Link;
    public String getDevEnvProperties(String prop){
        try{
            String path= System.getProperty("user.dir");
            FileInputStream inputStream =new FileInputStream(path+"/src/test/resources/Configurations/Dev_env.properties");
            Properties properties= new Properties();
            properties.load(inputStream);
         Link=properties.getProperty(prop);

        }catch (IOException exception){
            System.out.println("Please check Properties file"+exception.getMessage());
        }
        return Link;
    }
}

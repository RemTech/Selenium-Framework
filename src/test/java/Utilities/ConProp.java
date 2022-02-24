package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConProp {
    public String getEnvProp(String env){
        String data="";
        try{
            FileInputStream Inputstream=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Configurations/Dev_env.properties");
            Properties properties= new Properties();
            properties.load(Inputstream);
            properties.getProperty(env);
            data=properties.getProperty(env);
        }catch (IOException e){
            System.out.println("Please check your root file:"+e.getMessage());
        }
        return data;
    }
}

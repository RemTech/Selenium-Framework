package StepsDefinition.Hook;

import org.junit.After;
import org.junit.Before;
import utilities.ConfigCode;
import utilities.SeleniumDriver;

import java.io.IOException;

public class Hook extends SeleniumDriver {
    private SeleniumDriver Selenium;
    private String Browsers = "";
   private String path="";
    private ConfigCode Connection;

    public Hook(SeleniumDriver selenium) {
        this.Selenium = selenium;
        this.Connection=new ConfigCode();
    }

    @Before
    public void initialisation() throws Exception {
        Browsers=Connection.getDevEnvProperties("Browser");
        try {
            switch (Browsers.toLowerCase()){
                case "chrome":
                 path = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver", path+"/tools/chromedriver.exe");
                Selenium.driver.manage().window().maximize();
                break;
                case "firefox":
                     path = System.getProperty("user.dir");
                    System.setProperty("webdriver.gecko.driver", path+"/tools/geckodriver.exe");
                    Selenium.driver.manage().window().maximize();
                    break;
                case "edge":
                    path = System.getProperty("user.dir");
                    System.setProperty("webdriver.edge.driver", path+"/tools/msedgedriver.exe");
                    Selenium.driver.manage().window().maximize();
                    break;
                case"opera":
                    path = System.getProperty("user.dir");
                    System.setProperty("webdriver.opera.driver", path+"/tools/operadriver.exe");
                    Selenium.driver.manage().window().maximize();
                    break;
                default:
                    System.out.println("Please Check the browser section of the Properties file.");
            }
            }
        catch(Exception ex){
                System.out.println("Check tools folder in the framework" + ex);
            }
        }
        @After
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(5000);
        Selenium.driver.quit();
        }
    }


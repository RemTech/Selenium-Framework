package Stepdefs.Connect;

import Utilities.ConProp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import Utilities.Navigator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Hook extends Navigator {
    private Navigator Nav;
     private String browser="";
     private String Paths="";
     private ConProp Con;

    public Hook(Navigator nav) {
        this.Nav = nav;
        this.Con=new ConProp();
    }

    @Before
    public void loadBrowser() {

         browser=Con.getEnvProp("Browser");
        try {
            switch (browser.toLowerCase()){
                case "chrome":
                    Paths = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", Paths + "/tools/chromedriver.exe");
            Nav.drivers = new ChromeDriver();
            Nav.drivers.manage().window().maximize();
            break;
                case"firefox":
                    Paths = System.getProperty("user.dir");
                    System.setProperty("webdriver.gecko.driver", Paths + "/tools/geckodriver.exe");
                    Nav.drivers = new FirefoxDriver();
                    Nav.drivers.manage().window().maximize();
                    break;
                case"opera":
                    Paths = System.getProperty("user.dir");
                    System.setProperty("webdriver.opera.driver", Paths + "/tools/operadriver.exe");
                    Nav.drivers = new OperaDriver();
                    Nav.drivers.manage().window().maximize();
                    break;
                case"edge":
                    Paths = System.getProperty("user.dir");
                    System.setProperty("webdriver.edge.driver", Paths + "/tools/msedgedriver.exe");
                    Nav.drivers = new EdgeDriver();
                    Nav.drivers.manage().window().maximize();
                    break;
                default:
                    System.out.println("Please enter a valid browser Vendor");
                    break;
            }
        }
        catch (Exception e) {
           System.out.println("View This Carefully"+e.getMessage());
        }
    }
    @After
    public  void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        Nav.drivers.quit();
    }
}


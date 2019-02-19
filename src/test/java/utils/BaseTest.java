package utils;

import Utils.PropertiesUtil;
import Utils.URLs;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Page;


public class BaseTest {

    public static WebDriver driver;
    public static Page homePage;
    public static PropertiesUtil propertiesUtil = new PropertiesUtil("testdata.properties");

    @BeforeClass
    public static void launchHelloSignApp(){

        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get(URLs.HS_HOMEPAGE);
        homePage = new Page(driver);

    }

    public static void setChromeDriverProperty(){
        if(System.getProperty("os.name").contains("Windows")){
            System.setProperty("webdriver.chrome.driver", "/Users/amalrajsomarajan/Downloads/webdrivers/chrome/chromedriver.exe");
        }else{
            System.setProperty("webdriver.chrome.driver", "/Users/amalrajsomarajan/Downloads/webdrivers/chrome/chromedriver");
        }
    }

    @Test
    public void gotoHelloSignHomePage(){
        homePage.goToHelloSignHomePage();
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}

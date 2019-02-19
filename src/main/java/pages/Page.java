package pages;

import Utils.PropertiesUtil;
import Utils.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/nav[1]/div[8]/div[1]/img[1]")
    @CacheLookup
    private static WebElement homepage_login_mainmenu;

    @FindBy(css = "a[href='https://app.hellosign.com/account/logIn']")
    @CacheLookup
    private static WebElement homepage_login_hellosign;

    @FindBy(css = "a[href='https://portal.helloworks.com/']")
    @CacheLookup
    private static WebElement getHomepage_login_helloworks;


    public void goToHelloSignHomePage(){
        driver.get(URLs.HS_HOMEPAGE);
    }

    public void hover_over_login(){

        Actions actions = new Actions(driver);
        WebElement helloSignLogo = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.hellosign.com/']")));
        actions.moveToElement(helloSignLogo).click().build().perform();

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(URLs.HS_HOMEPAGE));

        WebElement login_main_menu = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(homepage_login_mainmenu));
        actions.moveToElement(login_main_menu);
        actions.click().build().perform();
    }

    public void click_on_helloSign_login(){
        Actions actions = new Actions(driver);
        WebElement login_sub_menu = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(homepage_login_hellosign));
        actions.moveToElement(login_sub_menu);
        actions.click().build().perform();

    }
}

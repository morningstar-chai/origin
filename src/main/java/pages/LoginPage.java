package pages;

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

public class LoginPage extends Page{

    //By userEmailByName = By.name("logIn.emailAddress");
    @FindBy(xpath = "//input[@name='logIn.emailAddress']")
    @CacheLookup
    private WebElement userEmailByName;

    //By continueButton = By.xpath("//button[@type='button']");
    @FindBy(xpath = "//button[@type='button']")
    private WebElement continueButton;

    //By userPassword = By.xpath("//input[@name='logIn.password']");
    @FindBy(xpath = "//input[@name='logIn.password']")
    private WebElement userPassword;

    //By signInSubmit = By.xpath("//span[@class='l-nowrap']");
    @FindBy(xpath = "//span[@class='l-nowrap']")
    private WebElement signInSubmit;

    //By signedInUserName = By.xpath("//span[@data-qa-ref='logged-in-email-element'] ");
    @FindBy(xpath = "//span[@data-qa-ref='logged-in-email-element']")
     private WebElement signedInUserName;

    //By homePageImage = By.xpath("//img[@class='l-img-centered']");
    @FindBy(xpath = "//img[@class='l-img-centered']")
    private WebElement homePageImage;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/nav[1]/div[8]/div[1]/img[1]")
    @CacheLookup
    private static WebElement mainMenu;

    @FindBy(xpath = "//a[href='https://app.hellosign.com/account/logOut']")
    @CacheLookup
    private static WebElement logOutButton;

    public LoginPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }

    public String goToLoginPage(){
        driver.get(URLs.HS_LOGINPAGE_URL);

        return driver.getCurrentUrl();
    }

    public String login_existing_user(String userEmail, String password){

        System.out.println("userEmailByName: " + userEmailByName);
        userEmailByName = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(userEmailByName));
        System.out.println("userEmailByName: " + userEmailByName);
        userEmailByName.clear();
        userEmailByName.sendKeys(userEmail);

        continueButton = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();

        userPassword = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(userPassword));
        userPassword.clear();
        userPassword.sendKeys(password);

        signInSubmit = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(signInSubmit));
        signInSubmit.click();

        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='headline']"))).getText();
    }

    public void logout_user(){

        Actions actions = new Actions(driver);

        WebElement mainMenu = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='m-app-topbar--menu--title--text']")));

        System.out.println("mainMenu: " + mainMenu);

        actions.moveToElement(mainMenu).build().perform();

        WebElement logOutButton = new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='//app.hellosign.com/account/logOut']")));

        System.out.println("logOutButton: " + logOutButton);

        actions.moveToElement(logOutButton).click().build().perform();

        actions.release().build().perform();
    }
}
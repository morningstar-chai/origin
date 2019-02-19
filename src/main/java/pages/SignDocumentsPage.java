package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignDocumentsPage extends Page {

    @FindBy(xpath = "//div[@class='choose-sign-method']")
    @CacheLookup
    private static List<WebElement> signMethodLinks;

    @FindBy(xpath = "//a[contains(text(),'Just Me')]")
    @CacheLookup
    private static WebElement justMeSignMethod;

    @FindBy(xpath = "//a[contains(text(),'Me & Others')]")
    @CacheLookup
    private static WebElement meAndOthersSignMethod;

    @FindBy(xpath = "//a[contains(text(),'Just Others')]")
    @CacheLookup
    private static WebElement justOtherSignMethod;

    @FindBy( xpath = "//div[@class='m-fancybox-modal-inner standard-modal']//img[@class='l-new-modal--close']")
    //div[@class='m-fancybox-modal-inner standard-modal']//img[@class='l-new-modal--close']
    @CacheLookup
    private static WebElement closePricingModal1;

    @FindBy(xpath = "//div[@class='m-fancybox-modal-inner standard-modal']//img[@class='l-new-modal--close']")
    @CacheLookup
    private static WebElement closePricingModal2;

    @FindBy(xpath = "//div[@id='quota_alert_num_documents_per_month']//img[@class='l-new-modal--close']")
    @CacheLookup
    private static WebElement closePricingModal3;

    @FindBy(id = "quota_alert_num_documents_per_month")
    @CacheLookup
    private static WebElement pricingModal;

    @FindBy(id = "//strong[contains(text(),'Your email has been sent!')]")
    @CacheLookup
    private static WebElement emailSentConfirmation;

    public SignDocumentsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Boolean get_signing_method_options(){

        for (WebElement signMethod :signMethodLinks) {
            System.out.println( "sign method link: " + signMethod.getText());
        }
        return signMethodLinks.isEmpty();
    }
    public void click_on_just_me_sign_method(){

        justMeSignMethod.click();
    }

    public void click_on_me_and_others_sign_method(){

        meAndOthersSignMethod.click();
    }

    public void click_on_just_others_sign_method(){

        justOtherSignMethod.click();
    }

    public String get_main_div_just_me_sign_page(){
        WebElement webElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Sign your documents')]")));
        return webElement.getText();
    }

    public String get_main_div_me_others_sign_page(){
        WebElement webElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Get your document signed')]")));
        return webElement.getText();
    }

    public String get_email_sent_confirmation(){
        emailSentConfirmation = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(emailSentConfirmation));
        String text = emailSentConfirmation.getText();
        return emailSentConfirmation.getText();
    }

    public void close_pricing_modal1(){

        closePricingModal1.click();
    }

    public void close_pricing_modal2(){

        closePricingModal2.click();
    }

    public void close_pricing_modal3(){

        closePricingModal3.click();
    }

    public void wait_for__visible_pricing_modal(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pricingModal));
    }

}

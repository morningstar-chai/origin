package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JustMeSignPage extends Page {

   @FindBy(linkText = "Fill Out & Sign")
   @CacheLookup
   private static WebElement fillOutSignButton;

   @FindBy(id= "//div[@id='wrap']")
   @CacheLookup
   private static WebElement viewDocMainDiv;

   @FindBy(linkText = "Continue")
   @CacheLookup
   private static WebElement continueButton;

   @FindBy(xpath = "//li[@id='action_button_text_date']//a[@class='l']")
   @CacheLookup
   private static WebElement dateTextBox;

   @FindBy(className = "doc_page_img")
   @CacheLookup
   private static WebElement documentImage;

   @FindBy(linkText = "Re-edit")
   @CacheLookup
   private static WebElement reEditButton;

   @FindBy(xpath = "//input[@id='tsm_group_send_recipient1']")
   @CacheLookup
   private static WebElement emailAddress;

    @FindBy(xpath = "//input[@id='request_subject']")
    @CacheLookup
    private static WebElement docTitle;

    @FindBy(xpath = "//button[@id='tsm_group_send_submit']")
    @CacheLookup
    private static WebElement sendRequestButton;

   public JustMeSignPage(WebDriver driver){

       super(driver);
       PageFactory.initElements(driver, this);

   }

   public void click_fill_out_sign_button(){

       fillOutSignButton = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(fillOutSignButton));
       fillOutSignButton.click();

   }

   public String click_on_continue_button() throws Exception{

       Thread.sleep(100);

       if (!get_current_frame().contains("fancybox-frame")){
           driver.switchTo().frame("fancybox-frame");
       }

       continueButton = new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='saveButton']")));
       System.out.println("Current frame:g" + get_current_frame());
       Actions actions = new Actions(driver);
       actions.moveToElement(continueButton);
       actions.click().build().perform();
       String text = continueButton.getText();
       driver.switchTo().defaultContent();

       return text;

   }

    public void drag_and_drop_date_text_box() throws Exception{

        System.out.println(">>>> drag_and_drop_date_text_box <<<<<");
        Thread.sleep(100);

        if (!get_current_frame().contains("fancybox-frame")){
            driver.switchTo().frame("fancybox-frame");
        }

        dateTextBox = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(dateTextBox));

        Actions actions = new Actions(driver);
        actions.moveToElement(dateTextBox).build().perform();

        documentImage = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(documentImage));
        System.out.println(">>>> dragging and dropping date text box <<<<<");
        actions.dragAndDrop(dateTextBox, documentImage).build().perform();

        driver.switchTo().defaultContent();

    }

    public String get_reEdit_Button_Text(){

        reEditButton = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(reEditButton));
        return reEditButton.getText();
    }

    public String get_current_frame(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        Object currentFrame = jsExecutor.executeScript("return self.name");
        System.out.println("Current Frame Name: " + currentFrame);
        return currentFrame.toString();
    }

    public void send_sign_request(){

        emailAddress = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailAddress));
        emailAddress.sendKeys("morningstar.chai@gmail.com");

        docTitle = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(docTitle));
        docTitle.sendKeys("please sign document.");

        Actions actions = new Actions(driver);
        sendRequestButton = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sendRequestButton));
        actions.moveToElement(sendRequestButton);
        actions.click().build().perform();
    }
}

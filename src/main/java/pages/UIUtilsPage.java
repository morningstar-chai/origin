package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtilsPage extends Page {

    public UIUtilsPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]/a[1]")
    @CacheLookup
    private static WebElement addFileLink;

    @FindBy(xpath = "//input[@name='file']")
    @CacheLookup
    private static WebElement addfileInputText;

    public void upload_file(String filePath) throws Exception{

        System.out.println("******* checking for visibility of add file button");
        //Actions actions = new Actions(driver);
        //addFileLink = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]/a[1]")));
        //actions.moveToElement(addFileLink).click().build().perform();
        //System.out.println("******* add file button " + addFileLink);

        System.out.println("******* uploading file ");

        addfileInputText = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='file']")));

        addfileInputText.sendKeys(filePath);

        Thread.sleep(5000);

        WebElement uploadedFile = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Rebate.pdf')]")));

        System.out.println("****** file uploaded!! " + uploadedFile.getText());

    }

}

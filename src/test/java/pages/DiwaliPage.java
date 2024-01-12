package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DiwaliPage {
    @FindBy(xpath = "//img[@src=\"https://d1tgh8fmlzexmh.cloudfront.net/ccbp-static-website/diwali-img.png\"]")
    WebElement diwaliimageEl;
    @FindBy(className = "diwali-top-section-heading")
    WebElement diwaliheadtextEl;
    @FindBy(className = "diwali-card-image")
    List<WebElement> diwaliimageElements;
    @FindBy(css = "h1.diwali-card-name")
    List<WebElement> diwalicardnames;
    @FindBy(css = "p.diwali-card-price")
    List<WebElement> diwalicardpriceElements;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backbuttonEl;
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/img")
    WebElement projectdeveloperImageEl;

    public WebDriver driver;
    public DiwaliPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    //perform action Elements
    public void clickdiwalipage(){
        diwaliimageEl.click();
    }
    public String diwaliHeading() {
        return diwaliheadtextEl.getText();
    }
    public void diwalicardimages() {
        for (WebElement imageElements : diwaliimageElements) {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(imageElements));
            imageElements.isDisplayed();
        }
    }
    public void verifyingItemnamesandorder(){
        String[] expOrder={"Diwali Air Balloon","Diwali - Lamp","Sparklers", "Fire Cracker"};
        System.out.println("Before waiting - Number of Diwali item prices found: " + diwalicardnames.size());

        // Wait for the elements to be present and visible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(diwalicardnames));
        } catch (TimeoutException e) {
            System.out.println("Timeout Exception: " + e.getMessage());
        }

        // Print information after waiting
        System.out.println("After waiting - Number of Diwali item prices found: " + diwalicardnames.size());
        for (WebElement diwalicardname : diwalicardnames) {
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(diwalicardname));
            diwalicardname.isDisplayed();
        }
    }






    public void verifyDiwaliItemPricesAndOrder() {
        // Expected order of Diwali item prices
        String[] expectedOrder = {"Rs 369", "Rs 50", "Rs 150", "Rs 560"};
        System.out.println("Before waiting - Number of Diwali item prices found: " + diwalicardpriceElements.size());

        // Wait for the elements to be present and visible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(diwalicardpriceElements));
        } catch (TimeoutException e) {
            System.out.println("Timeout Exception: " + e.getMessage());
        }

        // Print information after waiting
        System.out.println("After waiting - Number of Diwali item prices found: " + diwalicardpriceElements.size());
        for (WebElement diwalipriceitem : diwalicardpriceElements) {
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(diwalipriceitem));
            diwalipriceitem.isDisplayed();
        }
    }

    public void clickbackbutton(){
        backbuttonEl.click();
    }
    public WebElement findprojectImage(){
        return projectdeveloperImageEl;
    }




}



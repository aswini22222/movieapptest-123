package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FoodPage {
        @FindBy(xpath = "//img[@src=\"https://d1tgh8fmlzexmh.cloudfront.net/ccbp-static-website/food-img.png\"]")
        WebElement FoodimageEl;
        @FindBy(css = "h1.order-card-heading")
        WebElement FoodpageheadtextEl;
        @FindBy(css = "p.order-card-paragraph")
        WebElement ordercardparagraphEl;
        @FindBy(css = "button.order-card-button")
        WebElement ordercardbuttontextEl;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backbuttonEl;
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/img")
    WebElement projectdeveloperImageEl;



    public WebDriver driver;
        public FoodPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);

        }
        //perform action Elements
        public void clickfoodimage(){
            FoodimageEl.click();
        }
        public String foodtextHeading() {
            return FoodpageheadtextEl.getText();
        }

        public String orderparagraphtext(){
           return ordercardparagraphEl.getText();
        }
        public String OrdernowbuttonTExt(){
            return ordercardbuttontextEl.getText();
        }
    public void clickbackbutton(){
        backbuttonEl.click();
    }
    public WebElement findprojectImage(){
        return projectdeveloperImageEl;
    }





    }

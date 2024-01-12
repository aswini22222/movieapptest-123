package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewsPAge {
    @FindBy(xpath = "//img[@src=\"https://d1tgh8fmlzexmh.cloudfront.net/ccbp-static-website/news-paper-img.png\"]")
    WebElement NewsimageEl;
    @FindBy(css = "p.news-category")
    WebElement NewsheadTExtEl;
    @FindBy(css = "h1.news-title")
    WebElement newtitleEl;
    @FindBy(css = "p.news-description")
    WebElement newsDescriptionEl;
    @FindBy(css = "button.news-button")
    WebElement ReadmoreButtonTextEl;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backbuttonEl;
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/img")
    WebElement projectdeveloperImageEl;



    public WebDriver driver;
    public NewsPAge(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    //perform action Elements
    public void clicknewspage(){
        NewsimageEl.click();
    }
    public String newstextHeading() {
        return NewsheadTExtEl.getText();
    }

    public String newstitletext(){
        return newtitleEl.getText();
    }
    public String newsdescription(){
        return newsDescriptionEl.getText();
    }
    public String Readmorebuttontext(){
        return ReadmoreButtonTextEl.getText();
    }
    public void clickbackbutton(){
        backbuttonEl.click();
    }
    public WebElement findprojectImage(){
        return projectdeveloperImageEl;
    }





}



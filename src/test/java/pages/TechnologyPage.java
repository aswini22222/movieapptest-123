package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TechnologyPage {
    @FindBy(css = "img.my-project-image")
    WebElement technologyImageEl;
    @FindBy(className = "advanced-technologies-title")
    WebElement AdvancedTechnologiesTitle;
    @FindBy(className = "advanced-technologies-description")
    WebElement technologyDescription;
    @FindBy(className = "advanced-technologies-learn-more-button")
    WebElement learnmorebutton;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backbuttonEl;
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/img")
    WebElement projectdeveloperImageEl;

    public WebDriver driver;
    public TechnologyPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clicktechnologypage(){
        technologyImageEl.click();
    }
    public String technologyHeading() {
        return AdvancedTechnologiesTitle.getText();
    }
    public String technologyDesc(){
        return technologyDescription.getText();
    }
    public String learnmorebuttonTExt(){
        return learnmorebutton.getText();
    }
    public void clickbackbutton(){
        backbuttonEl.click();
    }
    public WebElement findprojectImage(){
        return projectdeveloperImageEl;
    }

}

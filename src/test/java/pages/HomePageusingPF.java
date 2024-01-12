package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageusingPF {
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div/img")
    WebElement projectsImageEl;
    @FindBy(how = How.CLASS_NAME,using = "my-projects-heading")
    WebElement projectsheadingEl;
    @FindBy(how = How.CLASS_NAME,using="my-projects-description")
    WebElement projectdescriptionEl;
    @FindBy(how = How.XPATH,using = "//img[@class='my-project-image']")
    List<WebElement> ProjectimageEl;

    public WebDriver driver;
    public HomePageusingPF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement findprojectImage(){
        return projectsImageEl;
    }
    public String projectsheading(){
        return projectsheadingEl.getText();
    }
    public String projectsdescription(){
        return projectdescriptionEl.getText();
    }



}



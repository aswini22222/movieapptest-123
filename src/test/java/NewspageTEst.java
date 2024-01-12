import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class NewspageTEst {
    public WebDriver driver;
    HomePageusingPF homePageusingPF;
    TechnologyPage technologyPage;
    DiwaliPage diwaliPage;
    FoodPage foodPage;
    NewsPAge newsPAge;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        homePageusingPF = new HomePageusingPF(driver);
        technologyPage =new TechnologyPage(driver);
        diwaliPage=new DiwaliPage(driver);
        foodPage=new FoodPage(driver);
        newsPAge=new NewsPAge(driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void NewspageUI() {
        newsPAge.clicknewspage();
        String expnewspageurl = "https://qamyprojects.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expnewspageurl));
        System.out.println("Navigated successfully to News page");
        //News page head text
        String expNEwshead = "NEWS OF THE DAY";
        String actualnewsheadtext = newsPAge.newstextHeading();
        Assert.assertEquals(expNEwshead,actualnewsheadtext, "News page  HEad TExt do not match");
        //News page paragraph Text
        String expnewspageparagraphText = "All educational institutions in Assam to reopen from November 2";
        String actualnewsparagraphtext = newsPAge.newstitletext();
        Assert.assertEquals(expnewspageparagraphText, actualnewsparagraphtext, "News page  paragraph TExt do not match");
        //New page Description
        String expnewspageDescText = "Uttar Pradesh's Gautam Buddh Nagar recorded 107 new Covid-19 cases on Saturday, pushing the district's infection tally to 15,803, official data showed. The number of active cases came down further to 1,384 from 1,477 on Friday and 1,523 on Thursday, according to the data released by the UP Health Department for a 24-hour period.";
        String actualnewsDescText = newsPAge.newsdescription();
        Assert.assertEquals(expnewspageparagraphText, actualnewsparagraphtext, "News page  Description TExt do not match");

        //checking Readmore now button text
        String expreadmorebuttontext = "Read more";
        String actualreadmoretext = newsPAge.Readmorebuttontext();
        Assert.assertEquals(expreadmorebuttontext,actualreadmoretext, "Read more Text do not Match");

    }
    @Test(priority = 1)


    public void testBackButton(){
        technologyPage.clicktechnologypage();
        String exptechnologypageurl="https://qamyprojects.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(exptechnologypageurl));
        //clicking back button
        technologyPage.clickbackbutton();
        String exphomepageurl="https://qamyprojects.ccbp.tech/";
        String actualhomeurl=driver.getCurrentUrl();
        Assert.assertEquals(actualhomeurl,exphomepageurl,"Urls do not match");
        //Test whether the software developer image is displayed
        Assert.assertTrue(technologyPage.findprojectImage().isDisplayed(),"Developer image was not displayed");
    }

}



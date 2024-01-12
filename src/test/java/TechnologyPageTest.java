import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageusingPF;
import pages.TechnologyPage;

import java.time.Duration;

public class TechnologyPageTest {
    public WebDriver driver;
    HomePageusingPF homePageusingPF;
    TechnologyPage technologyPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        homePageusingPF = new HomePageusingPF(driver);
        technologyPage =new TechnologyPage(driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void technologypageUI(){
        technologyPage.clicktechnologypage();
        String exptechnologypageurl="https://qamyprojects.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(exptechnologypageurl));
        System.out.println("Navigated successfully to technology page");

        //checking headtitle of technology page
        String ExptechnologyTExt="Advanced Technologies";
        String actualtechnologytext=technologyPage.technologyHeading();
        Assert.assertEquals(actualtechnologytext,ExptechnologyTExt,"Advanced Technologies text do not match");

        //checking technology page Description
        String ExpTEchtitledescription="Machinery and equipment developed from the application of scientific knowledge.";
        String actualtechDescText=technologyPage.technologyDesc();
        Assert.assertEquals(actualtechDescText,ExpTEchtitledescription,"Description text do not match");

        //learnmore buttontext
        String explearnmorebuttontext="Learn more";
        String actuallearnmorebuttonTExt=technologyPage.learnmorebuttonTExt();
        Assert.assertEquals(actuallearnmorebuttonTExt,explearnmorebuttontext,"Learn more button text do not match");

    }
    @Test(priority = 2)
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

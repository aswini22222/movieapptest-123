import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageusingPF;
import pages.TechnologyPage;
import pages.DiwaliPage;

import java.time.Duration;

public class DiwalipageTEst {
    public WebDriver driver;
    HomePageusingPF homePageusingPF;
    TechnologyPage technologyPage;
    DiwaliPage diwaliPage;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        homePageusingPF = new HomePageusingPF(driver);
        technologyPage =new TechnologyPage(driver);
        diwaliPage=new DiwaliPage(driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void DiwalipageUI(){
        diwaliPage.clickdiwalipage();
        String expdiwalipageurl="https://qamyprojects.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expdiwalipageurl));
        System.out.println("Navigated successfully to Diwali page");
        //Diwali head text
        String expdiwaliHeadText="Celebrate Diwali with your friends";
        String actualdiwaliheadtext=diwaliPage.diwaliHeading();
        Assert.assertEquals(actualdiwaliheadtext,expdiwaliHeadText,"Diwali HEad TExt do not match");
    }
  @Test(priority = 2)
    public void  verifyingdiwalicardimages(){
        diwaliPage.diwalicardimages();
  }
  @Test(priority = 3)
    public void Verifynamesandorder(){
        diwaliPage.verifyingItemnamesandorder();
  }
  @Test(priority = 4)
        public void verifyItempricesandOrder(){
        diwaliPage.verifyDiwaliItemPricesAndOrder();

      }
    @Test(priority = 5)
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
  }}




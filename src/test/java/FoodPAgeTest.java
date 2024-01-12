import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DiwaliPage;
import pages.HomePageusingPF;
import pages.TechnologyPage;
import pages.FoodPage;

import java.time.Duration;

public class FoodPAgeTest {
    public WebDriver driver;
    HomePageusingPF homePageusingPF;
    TechnologyPage technologyPage;
    DiwaliPage diwaliPage;
    FoodPage foodPage;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        homePageusingPF = new HomePageusingPF(driver);
        technologyPage =new TechnologyPage(driver);
        diwaliPage=new DiwaliPage(driver);
        foodPage=new FoodPage(driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void FoodpageUI() {
        foodPage.clickfoodimage();
        String expfoodpageurl = "https://qamyprojects.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expfoodpageurl));
        System.out.println("Navigated successfully to Food page");
        //Food page head text
        String expfoodpageHeadText = "Happy Meals";
        String actualfoodheadtext = foodPage.foodtextHeading();
        Assert.assertEquals(actualfoodheadtext, expfoodpageHeadText, "Food page  HEad TExt do not match");
        //Food page paragraph Text
        String expfoodpageparagraphText = "Discover the best foods over the 1,000 restaurants";
        String actualfoodparagraphtext = foodPage.orderparagraphtext();
        Assert.assertEquals(actualfoodparagraphtext, expfoodpageparagraphText, "Food page  paragraph TExt do not match");
        //checking order now button text
        String expordernowbuttontext = "Book Now";
        String actualbooknowtext = foodPage.OrdernowbuttonTExt();
        Assert.assertEquals(actualbooknowtext, expordernowbuttontext, "Book now Text do not Match");

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

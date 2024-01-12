import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageusingPF;

public class HomePageTest {
    public WebDriver driver;
    HomePageusingPF homePagepf;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        homePagepf = new HomePageusingPF(driver);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        }

    @Test(priority = 1)
    public void testhomepageUi(){
        Assert.assertTrue(homePagepf.findprojectImage().isDisplayed(),"Software Developer Image is not Displayed");
        String expprojectshead="My Projects";
        Assert.assertEquals(homePagepf.projectsheading(),expprojectshead,"Heading Text do not match");
        String expprojectsDescription="These are a few of my Static Website projects that I have developed using HTML, CSS and Bootstrap";
        Assert.assertEquals(expprojectsDescription,homePagepf.projectsdescription(),"Description do not match");
    }





}

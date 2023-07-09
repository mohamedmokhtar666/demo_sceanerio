package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeSuite
    public void beforeSuit()
    {
        System.out.println("Set Up System");

    }

    @BeforeClass
    public void setUp()
    {
       //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
      ChromeOptions options=new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

      //  WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Open WebSite");
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage=new HomePage(driver);

    }
    public WindowManager getWindowManager()
    {
        return new WindowManager(driver);
    }


    @BeforeMethod
    public void beforeMethod()
    {


        //System.out.println("Change Language To English");
        //driver.findElement(language).click();
        System.out.println("Go To Next Step");

    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Open Browser");
    }
    @AfterMethod
    public void takeScreenShot( ) {
        /*
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot Taken: " + screenShot.getAbsolutePath());
            try {
                Files.move(screenShot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            Files.move(screenshot, new File("resources/Screenshots/test.png"));
            Files.move(screenshot, new File("resources/Screenshots/test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass

    public void tearDown()
    {
        driver.quit();
        System.out.println("Close Website");
    }


    @AfterSuite
    public void afterSuit()
    {
        System.out.println("Close Chrome Browser");
    }

}

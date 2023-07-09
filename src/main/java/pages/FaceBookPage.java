package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FaceBookPage {
    private WebDriver driver;
    private By title =By.xpath("//h1[@class='gmql0nx0 l94mrbxd p1ri9a11 lzcic4wl']");
    private By logIn=By.cssSelector("#login_form > div.rq0escxv.l9j0dhe7.du4w35lb.pfnyh3mw.bkfpd7mw.bp9cbjyn.owycx6da.btwxx1t3.hv4rvrfc.dati1w0a.jb3vyjys.dlv3wnog.rl04r1d5.mysgfdmx.hddg9phg.mkhogb32.r0h9k63k > div:nth-child(3) > div > div > div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.pfnyh3mw.i1fnvgqd.bp9cbjyn.owycx6da.btwxx1t3.b5q2rw42.lq239pai.mysgfdmx.hddg9phg > div > span > span");
    private By emailField=By.xpath("//input[@name='email']");
    private By passwordField=By.xpath("//input[@name='pass']");
    private By buttonLogin=By.cssSelector("#loginbutton");
    private By likeBox=By.xpath("//span[text()='Liked']");

    public FaceBookPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getTitleResult()
    {
        return driver.findElement(title).getText();
    }
    public FaceBookPage enterLogIn(String email,String password)
    {
        //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(logIn)));
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            driver.findElement(emailField).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(logIn).click();
            return new FaceBookPage(driver);

    }
    public void clickLike()
    {

        driver.findElement(likeBox).click();
    }



}

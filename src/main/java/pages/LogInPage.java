package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    private By emailField=By.id("Email");
    private By passwordField=By.id("Password");
    private By rememberMeBox=By.id("RememberMe");
    private By logInButton=By.xpath("//*[@class='button-1 login-button']");
    private By textResult=By.xpath("//*[@class='ico-account']");
    public LogInPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public HomePage enterLogInForm(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeBox).click();
        driver.findElement(logInButton).click();
        return new HomePage(driver);
    }
    public String getVerifyAccount()
    {
        return driver.findElement(textResult).getText();
    }

}

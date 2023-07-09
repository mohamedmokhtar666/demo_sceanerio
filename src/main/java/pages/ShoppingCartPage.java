package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;
    private By quantity=By.xpath("//input[@class='qty-input']");
    private By termsConditionBox=By.id("termsofservice");

    private By checkOutButton=By.id("checkout");
    public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void changeQuantity(String num)
    {
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(num);
    }
    public void clickTermsCondition()
    {
        driver.findElement(termsConditionBox).click();
    }

public  CheckOutPage clickCheckOut()
{
    driver.findElement(checkOutButton).click();
    return new CheckOutPage(driver);
}

public class VerifyAccountPage{
        private WebDriver driver;
    private By emailField=By.id("Email");
    private By passwordField=By.id("Password");
    private By logInButton=By.xpath("//*[@class='button-1 login-button']");

    public VerifyAccountPage(WebDriver driver)
        {
            this.driver=driver;
        }
    public CheckOutPage enterLogInForm(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
        return new CheckOutPage(driver);
    }


    }

}

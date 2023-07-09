package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By registerField= By.xpath("//a[@class='ico-register']");
    private By logoutField=By.xpath("//a[@class='ico-logout']");
    private By loginField=By.xpath("//a[@class='ico-login']");
    private By searchBox=By.id("small-searchterms");
    private By searchButton=By.xpath("//button[@class='button-1 search-box-button']");
    private By faceBookBox=By.xpath("//li[@class='facebook']");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public RegisterPage  clickRegisterLink()
    {
        driver.findElement(registerField).click();
        return new  RegisterPage(driver);
    }
    public HomePage clickLogout()
    {
        driver.findElement(logoutField).click();
        return new HomePage(driver);
    }
    public LogInPage clickLoginLink()
    {
        driver.findElement(loginField).click();
        return new LogInPage(driver);

    }
    public ProductPage searchForProduct(String product)
    {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
        return new ProductPage(driver);
    }
    public FaceBookPage clickFaceBookLink()
    {
     driver.findElement(faceBookBox).click();
     return new FaceBookPage(driver);
    }



}

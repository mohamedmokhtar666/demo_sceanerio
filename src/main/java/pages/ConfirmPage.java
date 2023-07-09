package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    WebDriver driver;
    private By resultText=By.xpath("//div[@class='result']");
    private By continueButton=By.xpath("//a[@class='button-1 register-continue-button']");


    public ConfirmPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String getResultText()
    {
     return    driver.findElement(resultText).getText();
    }
    public HomePage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}

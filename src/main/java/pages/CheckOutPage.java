package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    private WebDriver driver;
    private By countrySelect=By.id("BillingNewAddress_CountryId");
    private By cityField=By.id("BillingNewAddress_City");
    private By addressField=By.id("BillingNewAddress_Address1");
    private By zipCodeField=By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberField=By.id("BillingNewAddress_PhoneNumber");
    private By continueButton1=By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
    private By shippingtMethod=By.id("shippingoption_1");
    private By continueButton2=By.xpath("//*[@class='button-1 shipping-method-next-step-button']");
    private By paymentMethod=By.id("paymentmethod_0");
    private By continueButton3=By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private By continueButton4=By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private By confirmButton=By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    private By textConfirmation=By.xpath("//div[contains(@class,'title')]/strong[text()='Your order has been successfully processed!']");
    private By orderNumber=By.xpath("//div[@class='order-number']");
    private By finalButton=By.xpath("//button[@class='button-1 order-completed-continue-button']");

    public CheckOutPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enterAddressFields(String country,String city,String address,String zipCode,String phone)
    {
        Select selectCountry=new Select(driver.findElement(countrySelect));
        selectCountry.selectByVisibleText(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(continueButton1).click();
    }
    public void enterShippingMethod()
    {
        driver.findElement(shippingtMethod).click();
        driver.findElement(continueButton2).click();
    }
    public void enterPaymentMethod()
    {
        driver.findElement(paymentMethod).click();
        driver.findElement(continueButton3).click();
    }
    public void enterPaymentInformation()
    {
        driver.findElement(continueButton4).click();
    }
    public void clickConfirmation()
    {
        driver.findElement(confirmButton).click();
    }
    public String getTextConformation()
    {
        return driver.findElement(textConfirmation).getText();
    }
    public String getOrderNumber()
    {
        return driver.findElement(orderNumber).getText();
    }
    public HomePage clickFinishCheckout()
    {
        driver.findElement(finalButton).click();
        return new HomePage(driver);
    }


}

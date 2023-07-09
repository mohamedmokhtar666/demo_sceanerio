package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RegisterPage {
    private WebDriver driver;

    private By genderField=By.id("gender-male");
    private By firstNameField=By.id("FirstName");
    private By lastNameField=By.id("LastName");
    private By dataField=By.xpath("//select[@name='DateOfBirthDay']");
    private By monthField=By.xpath("//select[@name='DateOfBirthMonth']");
    private By yearField=By.xpath("//select[@name='DateOfBirthYear']");
    private By emailField=By.id("Email");
    private By companyField=By.id("Company");
    private By optionFiled=By.id("Newsletter");
    private By passwordField=By.id("Password");
    private By confirmPasswordFiled=By.id("ConfirmPassword");
    private By registerButton=By.id("register-button");
    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enterRegisterFields(String firstname,String lastname,String day,String month,String year,String email,
                                    String companyName,String password,String confirmPassword)
    {
        driver.findElement(genderField).click();
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
      //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Select selectDay=new Select(driver.findElement(dataField));
        selectDay.selectByValue(day);
        Select selectMonth=new Select(driver.findElement(monthField));
        selectMonth.selectByValue(month);
        Select selectYear=new Select(driver.findElement(yearField));
        selectYear.selectByValue(year);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(companyField).sendKeys(companyName);
        driver.findElement(optionFiled).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordFiled).sendKeys(confirmPassword);

    }
    public ConfirmPage clickRegister()
    {
        driver.findElement(registerButton).click();
        return  new ConfirmPage(driver);
    }



/*
    public List<String> getSelectedOptions(){
        List<WebElement>  selectedElements= findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    private Select findDropDownElement()
    {
        return new Select(driver.findElement(genderField));
    }*/

}

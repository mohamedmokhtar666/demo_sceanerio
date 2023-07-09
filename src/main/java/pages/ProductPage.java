package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage
{
    private WebDriver driver;

    private By productTitle=By.xpath("//h2[@class='product-title']");
    private By addToCardBox=By.xpath("//div[@class='buttons']/button[@class='button-2 product-box-add-to-cart-button']");
    private By shoppingCart=By.xpath("//p[@class='content']/a");

    public ProductPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getTitleProduct()
    {
       return driver.findElement(productTitle).getText();
    }
    public ProductDescrptionPage clickOnAddToCart()
    {
        driver.findElement(addToCardBox).click();
        return new ProductDescrptionPage(driver);
    }


public class ProductDescrptionPage{
        private WebDriver driver;
        private By addToCart=By.id("add-to-cart-button-4");

        public ProductDescrptionPage(WebDriver driver)
        {
            this.driver=driver;
        }
        public ShoppingCartPage confirmAddToCart()
        {
            driver.findElement(addToCart).click();
            driver.findElement(shoppingCart).click();
            return new ShoppingCartPage(driver);
        }




}


}

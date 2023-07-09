package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FaceBookPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {


    @Test
    public void testLogIn()
    {
        System.out.println("Login In");
        var loginPage=homePage.clickLoginLink();
        loginPage.enterLogInForm("mohamedmokhta1113211612112@gmail.com","987654321");
        assertEquals(loginPage.getVerifyAccount(),"My account","Fail Log In ");

    }

    @Test (dependsOnMethods = "testLogIn")
    public void testSearchProduct()
    {
        System.out.println("Search For Product");
        String product="Apple MacBook";
         var productPage=homePage.searchForProduct(product);
        assertEquals(productPage.getTitleProduct(),"Apple MacBook Pro 13-inch","Title Product Incorrect");
        var productDescription= productPage.clickOnAddToCart();
        var shippingCart =productDescription.confirmAddToCart();
        shippingCart.changeQuantity("3");
        shippingCart.clickTermsCondition();
        var checkOutPage=shippingCart.clickCheckOut();
       // var checkOutPage=  verifyAccount.enterLogInForm("hmedali666@gmail.com","987654321");
        checkOutPage.enterAddressFields("Egypt","cairo","cairo","02","0112886585");
        checkOutPage.enterShippingMethod();
        checkOutPage.enterPaymentMethod();
        checkOutPage.enterPaymentInformation();
        checkOutPage.clickConfirmation();
        assertEquals(checkOutPage.getTextConformation(),"Your order has been successfully processed!","Conformation Incorrect");
        System.out.println(checkOutPage.getOrderNumber());
        checkOutPage.clickFinishCheckout();




    }

    @Test (dependsOnMethods = "testSearchProduct")
    public void testSwitchToFaceBookLink()
    {
        System.out.println("Switch To New Tab");
        var faceBookPage=  homePage.clickFaceBookLink();
        getWindowManager().switchToTabs("NopCommerce");
        assertEquals(faceBookPage.getTitleResult(),"NopCommerce","Page Incorrect");
        faceBookPage.enterLogIn("01012492855","2411995");
        faceBookPage.clickLike();




    }

}

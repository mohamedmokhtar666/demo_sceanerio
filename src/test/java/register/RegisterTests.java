package register;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTest {

    @Test
    public void testRegisterForm()
    {
        System.out.println("Sign Up");
        System.out.println("Enter Data");
     var registerPage= homePage.clickRegisterLink();
     registerPage.enterRegisterFields("mohamed","mokhtar","24","1","1990",
             "mohamedmokhta1113211612112@gmail.com","Iti",
             "987654321","987654321");
    // registerPage.clickRegister();
     var confirmPage=registerPage.clickRegister();

         assertEquals(confirmPage.getResultText(),"Your registration completed","Registration Incorrect");
        confirmPage.clickContinueButton();
        System.out.println("LogOut");
        homePage.clickLogout();
        System.out.println("Login In");
     var logInPage=homePage.clickLoginLink();
     logInPage.enterLogInForm("mohamedmokhta111321612112@gmail.com","987654321");
     assertEquals(logInPage.getVerifyAccount(),"My account","Fail Log In ");



    }

}

package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.*;

public class TTTestCase1 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case1:Log in on page")
    public void TestCase1(String email, String password) {
        LoginToTheSystemFromLoginPage loginPage = new LoginToTheSystemFromLoginPage();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickOnLoginButton();
    }
}


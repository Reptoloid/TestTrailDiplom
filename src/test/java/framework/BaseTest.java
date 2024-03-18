package framework;

import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import static framework.Browser.*;

@Listeners(TestListener.class)
public class BaseTest {
    private static final TextBox EMAIL = new TextBox(By.xpath("//input[@id='name']"));
    private static final TextBox PASSWORD = new TextBox(By.xpath("//input[@id='password']"));
    private static final Button LOGIN_BUTTON =new Button(By.xpath("//button[@class='loginpage-button-sso-disable loginpage-button-sso-disable-hover  loginpage-button-sso-disable-active']"));


    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        getInstance();
        windowsMaximize();
        navigateTo(PropertyReader.getProperty("base.URL"));
    }
    public void setLogin(String email, String password){
        EMAIL.sendKeys(String.valueOf(email));
        PASSWORD.sendKeys(String.valueOf(password));
        LOGIN_BUTTON.click();
    }


    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        quite();
    }


}

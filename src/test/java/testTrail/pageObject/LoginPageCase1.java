package testTrail.pageObject;


import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class LoginPageCase1 extends BasePage {
    private static final String PAGE_LOCATOR ="//div[@class='logo loginpage-logo']//a";
    private static final String EMAIL ="//input[@id='name']";
    private static final String PASSWORD ="//input[@id='password']";
    private static final String LOGIN_BUTTON ="//button[@class='loginpage-button-sso-disable loginpage-button-sso-disable-hover  loginpage-button-sso-disable-active']";


    public LoginPageCase1() {
        super(By.xpath(PAGE_LOCATOR), "Login Page");
    }
   // @Step("Set email")
    public void setEmail(String email){
        TextBox setEmail = new TextBox(By.xpath(String.format(EMAIL)));
        setEmail.sendKeys(String.valueOf(email));
    }
   // @Step("Set password")
    public void setPassword(String password){
        TextBox setPassword = new TextBox(By.xpath(String.format(PASSWORD)));
        setPassword.sendKeys(String.valueOf(password));
    }
   // @Step("Login into the project")
    public void clickOnLoginButton(){
        Button clickOnButton = new Button(By.xpath(LOGIN_BUTTON));
        clickOnButton.click();
    }


}

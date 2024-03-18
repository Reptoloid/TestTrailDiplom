package testTrail.pageObject;


import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class LoginToTheSystemFromLoginPage extends BasePage {
    private static final String PAGE_LOCATOR ="//div[@class='logo loginpage-logo']//a";
    private static final TextBox EMAIL = new TextBox(By.xpath("//input[@id='name']"));
    private static final TextBox PASSWORD = new TextBox(By.xpath("//input[@id='password']"));
    private static final Button LOGIN_BUTTON =new Button(By.xpath("//button[@class='loginpage-button-sso-disable loginpage-button-sso-disable-hover  loginpage-button-sso-disable-active']"));


    public LoginToTheSystemFromLoginPage() {
        super(By.xpath(PAGE_LOCATOR), "Login Page");
    }
    public void setEmail(String email){
        EMAIL.sendKeys(String.valueOf(email));
    }
    public void setPassword(String password){
        PASSWORD.sendKeys(String.valueOf(password));
    }
    public void clickOnLoginButton(){
        LOGIN_BUTTON.click();
    }


}

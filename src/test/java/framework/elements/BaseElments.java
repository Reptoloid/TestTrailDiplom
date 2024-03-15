package framework.elements;

import framework.Browser;
import framework.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.Browser.getDriver;
import static framework.Browser.waitForPageLoad;
import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public abstract class BaseElments {

    private By by;
    private WebElement element;


    private List<WebElement> elements;


    public BaseElments(By by) {
        this.by = by;
    }

    public static String getLoc(final String key) {
        return getProperty(key);
    }

    public WebElement getElement() {
        isElementPresent();
        return element;
    }

    public List<WebElement> getElements() {
        areElementsPresent();
        return elements;
    }

    protected abstract String getElementType();


    public void sendKeys(String sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
    }

    public void click() {
        isElementPresent();
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='5px solid red'", element);
            isElementClickable();
            getElement().click();
        }
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public String getText() {
        getElement().getText();
        System.out.println(getProperty("log.get.text") + ": " + getElement().getText());
        return getElement().getText();
    }

    public void clickAndWait() {
        click();
        waitForPageLoad();
    }

    public void moveAndClickByAction() {
        Actions actions = new Actions(Browser.getInstance().getDriver());
        actions.moveToElement(element)
                .click()
                .perform();
    }
    public void select(String value){
        isElementPresent();
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void moveToElement() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
    }

    public boolean isElementClickable() {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(getIntProperty("element.timeout"))).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable " + getElementType() + ": " + by);
            return false;
        }
    }

    public boolean isElementPresent() {
        try {
            getDriver().manage().timeouts().implicitlyWait(new PropertyReader("config.properties").
                    getIntProperty("timeout"), TimeUnit.SECONDS);
            element = getDriver().findElement(by);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(getElementType() + ": " + by + "is not present. Exeption - " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean areElementsPresent() {
        try {
            getDriver().manage().timeouts().implicitlyWait(new PropertyReader("config.properties").
                    getIntProperty("timeout"), TimeUnit.SECONDS);
            elements = getDriver().findElements(by);
            return !element.isDisplayed();
        } catch (Exception e) {
            System.out.println(getElementType() + ": " + by + "is not present. Exeption - " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean isSelected() {
        isElementPresent();
        System.out.println((getProperty("log.select") + element.getText()));
        return element.isSelected();
    }

    public boolean isDisplayed() {
        isElementPresent();
        if (element.isDisplayed()) {
            System.out.println(getElementType() + ": " + by + "is dispalayed");
            return true;
        } else {
            System.out.println(getElementType() + ": " + by + "is not dispalayed");
            return false;
        }
    }
    public void clickViaJS() {
        if (isElementPresent()) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        }
    }
    public void scrollIntoView() {
        isElementPresent();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void refreshPage() {
        getDriver().navigate().refresh();
        waitForPageLoad();
    }
}

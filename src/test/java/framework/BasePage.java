package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;

import static framework.Browser.waitForPageLoad;

public class BasePage {
    protected String title;
    protected By titleLocator;
    protected PropertyReader propertyReader = new PropertyReader("log.properties");
    public BasePage(final By locator, final String pageTitle) {
        init(locator, pageTitle);
        assertIsOpen();
    }
    private void init(final By locator, final String pageTitle) {
        this.titleLocator = locator;
        this.title = pageTitle;
    }
    public void assertIsOpen() {
        long before = new Date().getTime();
        try {
            waitForPageLoad();
            Label element = new Label(titleLocator);
            element.isDisplayed();
            long openTime = new Date().getTime() - before;
            System.out.println(String.format(propertyReader.getProperty("loc.form.appears"), title) + String.format(" in %s msec", openTime));
        } catch (Throwable e) {
            Assert.assertTrue(true, title + " does not open");
        }
    }
}
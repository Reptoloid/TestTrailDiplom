package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import static framework.Browser.*;

@Listeners(TestListener.class)
public class BaseTest {

    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        getInstance();
        windowsMaximize();
        navigateTo(PropertyReader.getProperty("base.URL"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        quite();
    }
}

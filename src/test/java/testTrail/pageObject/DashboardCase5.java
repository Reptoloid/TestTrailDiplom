package testTrail.pageObject;

import com.github.javafaker.Faker;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class DashboardCase5 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final String OPEN_TEST_RUNS_AND_RESULTS = "//a[@id='navigation-runs']";
    private static final String ADD_TEST_PLAN_BUTTON = "//a[@id='navigation-plans-add']";
    private static final String SET_NAME_FOR_TEST_PLAN = "//input[@id='name']";
    private static final String SET_DECRIPTION_FOR_TEST_PLAN = "//div[@id='description_display']";
    private static final String ADD_NEW_TEST_PLAN_BUTTON = "//button[@id='accept']";
    private static final String CREATION_CHECK = "//div[@class='message message-success']";

    public DashboardCase5() {
        super(By.xpath(PAGE_LOCATOR), "Dashboard");
    }

    @Step("Choose random project")
    public WebElement productSelection() {
        Random random = new Random();
        int i = random.nextInt(1, PRODUCT_LIST.size()) - 1;
        productName = PRODUCT_LIST.get(i);
        System.out.println(productName);
        return productItem = getDriver().findElement(By.xpath(String.format(OPEN_PROJECT, productName)));
    }
    @Step("Click on project")
    public void clickOnProductItem() {
        productItem.click();
    }
    @Step("Open Test&Runs Results page")
    public void openTestRunsAndResults() {
        TextBox testRunsAndResult = new TextBox(By.xpath(OPEN_TEST_RUNS_AND_RESULTS));
        testRunsAndResult.click();
    }
    @Step("Create a test plan")
    public void addTestPlan() {
        Button addTestPlanButton = new Button(By.xpath(ADD_TEST_PLAN_BUTTON));
        addTestPlanButton.click();
    }
    @Step("Set test plan name")
    public void setNameForTestPlan() {
        TextBox testPlanName = new TextBox(By.xpath(SET_NAME_FOR_TEST_PLAN));
        testPlanName.sendKeys(name);
        TextBox testPlaneDescription = new TextBox(By.xpath(SET_DECRIPTION_FOR_TEST_PLAN));
        testPlaneDescription.sendKeys(faker.chuckNorris().fact());
    }
    @Step("Create the test plan")
    public void addPlanButton() {
        Button addTestPlanButton = new Button(By.xpath(ADD_NEW_TEST_PLAN_BUTTON));
        addTestPlanButton.click();
    }
    @Step("Check success creation")
    public void creationCheck() {
        TextBox checkSuccessMessage = new TextBox(By.xpath(CREATION_CHECK));
        if (checkSuccessMessage.isElementPresent()) {
            System.out.println("Test plan was seccessfully create");
        } else {
            System.out.println("Error");
        }
    }
    @Step("TestCase5")
    public void testCase5() {
        productSelection();
        clickOnProductItem();
        openTestRunsAndResults();
        addTestPlan();
        setNameForTestPlan();
        addPlanButton();
        creationCheck();
    }
}

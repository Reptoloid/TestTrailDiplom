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

public class CreateTestPlanForProject extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final TextBox OPEN_TEST_RUNS_AND_RESULTS = new TextBox(By.xpath("//a[@id='navigation-runs']"));
    private static final Button ADD_TEST_PLAN_BUTTON = new Button(By.xpath("//a[@id='navigation-plans-add']"));
    private static final TextBox SET_NAME_FOR_TEST_PLAN = new TextBox(By.xpath("//input[@id='name']"));
    private static final TextBox SET_DECRIPTION_FOR_TEST_PLAN = new TextBox(By.xpath("//div[@id='description_display']"));
    private static final Button ADD_NEW_TEST_PLAN_BUTTON = new Button(By.xpath("//button[@id='accept']"));
    private static final TextBox CREATION_CHECK = new TextBox(By.xpath("//div[@class='message message-success']"));

    public CreateTestPlanForProject() {
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
        OPEN_TEST_RUNS_AND_RESULTS.click();
    }
    @Step("Create a test plan")
    public void addTestPlan() {
        ADD_TEST_PLAN_BUTTON.click();
    }
    @Step("Set test plan name")
    public void setNameForTestPlan() {
        SET_NAME_FOR_TEST_PLAN.sendKeys(name);
        SET_DECRIPTION_FOR_TEST_PLAN.sendKeys(faker.chuckNorris().fact());
    }
    @Step("Create the test plan")
    public void addPlanButton() {
        ADD_NEW_TEST_PLAN_BUTTON.click();
    }
    @Step("Check success creation")
    public void creationCheck() {
        softAssert.assertTrue(CREATION_CHECK.isElementPresent(),
                "Report was create success");
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

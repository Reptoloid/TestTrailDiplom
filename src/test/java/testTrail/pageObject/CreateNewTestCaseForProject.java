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

public class CreateNewTestCaseForProject extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.chuckNorris().fact();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final Button OPEN_TESTCASES_PAGE = new Button(By.xpath("//a[@id='navigation-suites']"));
    private static final Button ADD_TEST_CASES_BUTTON = new Button(By.xpath("//a[@id='sidebar-cases-add']"));
    private static final TextBox ADD_TITLE_FOR_TEST_CASES = new TextBox(By.xpath("//input[@class='form-control form-control-full form-fields ']"));
    private static final TextBox CLICK_ON_TYPE_LIST = new TextBox(By.xpath("//div[@id='type_id_chzn']//a"));
    private static final TextBox ADD_TYPE = new TextBox(By.xpath("//li[@id='type_id_chzn_o_" + (int) (Math.random() * 11) + "']"));
    private static final TextBox CLICK_ON_PRIORITY_LIST  = new TextBox(By.xpath("//div[@id='priority_id_chzn']"));
    private static final TextBox ADD_PRIORITY = new TextBox(By.xpath("//li[@id='priority_id_chzn_o_" +(int) Math.random() * 4 + "']"));
    private static final TextBox ADD_STEPS = new TextBox(By.xpath("//div[@id='custom_steps_display']"));
    private static final Button CREATE_TEST_CASE = new Button(By.xpath("//button[@id='accept']"));
    private static final TextBox SUCCESS_CREATION = new TextBox(By.xpath("//div[@class='message message-success']"));


    public CreateNewTestCaseForProject() {
        super(By.xpath(PAGE_LOCATOR), "Dashboard");
    }
    @Step("Choose random project")
    public WebElement productSelection() {
        Random random = new Random();
        int i = random.nextInt(1, PRODUCT_LIST.size())-1;
        productName = PRODUCT_LIST.get(i);
        System.out.println(productName);
        return productItem = getDriver().findElement(By.xpath(String.format(OPEN_PROJECT, productName)));
    }
    @Step("Click on project")
    public void clickOnProductItem(){
        productItem.click();
    }
    @Step("Open dashboardpage")
    public void goToDasboard() {
        Button dashboardButton = new Button(By.xpath(PAGE_LOCATOR));
        dashboardButton.click();
    }
    @Step("Open testcase page")
    public void goToTestcasesPage() {
        OPEN_TESTCASES_PAGE.click();
    }
    @Step("Create a new testcase")
    public void addTestCase() {
        ADD_TEST_CASES_BUTTON.click();
    }
    @Step("Add title for testcase")
    public void addTitleForCase() {
        ADD_TITLE_FOR_TEST_CASES.sendKeys(name);
    }
    @Step("Add type for testcase")
    public void addType(){
        CLICK_ON_TYPE_LIST.click();
        ADD_TYPE.click();
    }
    @Step("Add priority for testcase")
    public void addPriority(){
        CLICK_ON_PRIORITY_LIST.click();
        ADD_PRIORITY.click();
    }
    @Step("Add steps for testcase")
    public void addSteps(){
        ADD_STEPS.scrollIntoView();
        ADD_STEPS.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rutrum dolor vitae luctus ");
    }
    @Step("Create the test case")
    public void clickOnCreateNewTestCase(){
        CREATE_TEST_CASE.scrollIntoView();
        CREATE_TEST_CASE.clickAndWait();
    }
    @Step("Check success creation")
    public void checkTestCaseCreation(){
        softAssert.assertTrue(SUCCESS_CREATION.isElementPresent(),
                "Report was create success");
    }
    @Step("TestCase3")
    public void testCase3() {
        goToDasboard();
        productSelection();
        clickOnProductItem();
        goToTestcasesPage();
        addTestCase();
        addTitleForCase();
        addType();
        addPriority();
        addSteps();
        clickOnCreateNewTestCase();
        checkTestCaseCreation();
        softAssert.assertAll();
    }

}

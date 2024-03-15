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

public class DashboardCase3 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.chuckNorris().fact();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_TESTCASES_PAGE = "//a[@id='navigation-suites']";
    private static final String ADD_TEST_CASES_BUTTON = "//div[@class='button-group']//a[@class='button button-left button-add' and contains(@href,'index')]";
    private static final String ADD_TITLE_FOR_TEST_CASES = "//input[@class='form-control form-control-full form-fields ']";
    private static final String CLICK_ON_TYPE_LIST = "//div[@id='type_id_chzn']//a";
    private static final String ADD_TYPE = "//li[@id='type_id_chzn_o_" + (int) (Math.random() * 11) + "']";
    private static final String CLICK_ON_PRIORITY_LIST  = "//div[@id='priority_id_chzn']";
    private static final String ADD_PRIORITY = "//li[@id='priority_id_chzn_o_" +(int) Math.random() * 4 + "']";
    private static final String ADD_STEPS = "//div[@id='custom_steps_display']";
    private static final String CREATE_TEST_CASE = "//button[@id='accept']";
    private static final String SUCCESS_CREATION = "//div[@class='message message-success']";


    public DashboardCase3() {
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
        Button testCasesButton = new Button(By.xpath(OPEN_TESTCASES_PAGE));
        testCasesButton.click();
    }
    @Step("Create a new testcase")
    public void addTestCase() {
        Button addTestCasesButton = new Button(By.xpath(ADD_TEST_CASES_BUTTON));
        addTestCasesButton.click();
    }
    @Step("Add title for testcase")
    public void addTitleForCase() {
        TextBox addTitle = new TextBox(By.xpath(ADD_TITLE_FOR_TEST_CASES));
        addTitle.sendKeys(name);
    }
    @Step("Add type for testcase")
    public void addType(){
        TextBox clickOnTypeList = new TextBox(By.xpath(CLICK_ON_TYPE_LIST));
        clickOnTypeList.click();
        TextBox addType = new TextBox(By.xpath(ADD_TYPE));
        addType.click();
    }
    @Step("Add priority for testcase")
    public void addPriority(){
        TextBox clickOnPriorityList = new TextBox(By.xpath(CLICK_ON_PRIORITY_LIST));
        clickOnPriorityList.click();
        TextBox addPriority = new TextBox(By.xpath(ADD_PRIORITY));
        addPriority.click();
    }
    @Step("Add steps for testcase")
    public void addSteps(){
        TextBox addSteps = new TextBox(By.xpath(ADD_STEPS));
        addSteps.scrollIntoView();
        addSteps.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rutrum dolor vitae luctus ");
    }
    @Step("Create the test case")
    public void clickOnCreateNewTestCase(){
        Button addTestCaseButton = new Button(By.xpath(CREATE_TEST_CASE));
        addTestCaseButton.scrollIntoView();
        addTestCaseButton.clickAndWait();
    }
    @Step("Check success creation")
    public void checkTestCaseCreation(){
        TextBox successCreation = new TextBox(By.xpath(SUCCESS_CREATION));
        if(successCreation.isElementPresent()){
            System.out.println("TestCase was successfully create");
        }else {
            System.out.println("TestCase wasn't successfully create");
        }
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
    }

}

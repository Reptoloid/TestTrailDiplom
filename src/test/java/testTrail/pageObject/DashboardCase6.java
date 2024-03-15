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

public class DashboardCase6 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final String OPEN_TESTCASES_PAGE = "//a[@id='navigation-suites']";
    private static final String TEST_CASE_TABLE = "//div[@class='group grid-container']";
    private static final String CHOOSE_A_TEST_CASE_FOR_DELETE = "//input[@class='selectionCheckbox']";
    private static final String DELETE_BUTTON = "//a[@id='deleteCases']";
    private static final String DELETE_POP_UP = "//div[@id='casesDeletionDialog']//div[@class='button-group dialog-buttons-highlighted']//a[@class='button button-left button-ok button-positive dialog-action-default' and @data-testid='deleteCaseDialogActionDefault']";
    private static final String ADD_TEST_CASES_BUTTON = "//a[@id='sidebar-cases-add']";
    private static final String ADD_TITLE_FOR_TEST_CASES = "//input[@class='form-control form-control-full form-fields ']";
    private static final String CLICK_ON_TYPE_LIST = "//div[@id='type_id_chzn']//a";
    private static final String ADD_TYPE = "//li[@id='type_id_chzn_o_" + (int) (Math.random() * 11) + "']";
    private static final String CLICK_ON_PRIORITY_LIST  = "//div[@id='priority_id_chzn']";
    private static final String ADD_PRIORITY = "//li[@id='priority_id_chzn_o_" +(int) Math.random() * 4 + "']";
    private static final String ADD_STEPS = "//div[@id='custom_steps_display']";
    private static final String CREATE_TEST_CASE = "//button[@id='accept']";
    private static final String BREADCRUMBS_CLICK = "//div[@class='content-breadcrumb']//a";
    public DashboardCase6() {
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
    @Step("Open test case page")
    public void clickOnTestCasePage(){
        TextBox goToTestCasePage = new TextBox(By.xpath(OPEN_TESTCASES_PAGE));
        goToTestCasePage.click();
    }
    @Step("Choose the test cases")
     public void setChooseATestCaseForDelete(){
        TextBox chooseATestCase = new TextBox(By.xpath(CHOOSE_A_TEST_CASE_FOR_DELETE));
        chooseATestCase.click();
    }
    @Step("Click on delete button ")
    public void clickOnDeleteButton(){
        Button clickOnDeleteButton = new Button(By.xpath(DELETE_BUTTON));
        clickOnDeleteButton.click();
    }
    @Step("Click on delete button in pop up")
    public void clickOnDeletePopUp(){
        Button clickOnPopUp = new Button(By.xpath(DELETE_POP_UP));
        clickOnPopUp.click();
    }
    @Step("Create a test case")
    public void addTestCase() {
        Button addTestCasesButton = new Button(By.xpath(ADD_TEST_CASES_BUTTON));
        addTestCasesButton.click();
    }
    @Step("Add title for test case")
    public void addTitleForCase() {
        TextBox addTitle = new TextBox(By.xpath(ADD_TITLE_FOR_TEST_CASES));
        addTitle.sendKeys(name);
    }
    @Step("Add type for test case")
    public void addType(){
        TextBox clickOnTypeList = new TextBox(By.xpath(CLICK_ON_TYPE_LIST));
        clickOnTypeList.click();
        TextBox addType = new TextBox(By.xpath(ADD_TYPE));
        addType.click();
    }
    @Step("Add priority for test case")
    public void addPriority(){
        TextBox clickOnPriorityList = new TextBox(By.xpath(CLICK_ON_PRIORITY_LIST));
        clickOnPriorityList.click();
        TextBox addPriority = new TextBox(By.xpath(ADD_PRIORITY));
        addPriority.click();
    }
    @Step("Add steps for test case")
    public void addSteps(){
        TextBox addSteps = new TextBox(By.xpath(ADD_STEPS));
        addSteps.scrollIntoView();
        addSteps.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rutrum dolor vitae luctus ");
    }
    @Step("Cleck on create button")
    public void clickOnCreateNewTestCase(){
        Button addTestCaseButton = new Button(By.xpath(CREATE_TEST_CASE));
        addTestCaseButton.scrollIntoView();
        addTestCaseButton.clickAndWait();
    }
    @Step("Click on breadcrumbs link  ")
    public void setBreadcrumbsClick(){
        TextBox breadcrunbs = new TextBox(By.xpath(BREADCRUMBS_CLICK));
        breadcrunbs.clickAndWait();
    }
    @Step("Check test case for delete")
    public void checkTestCaseTable(){
        TextBox testCaseTable = new TextBox(By.xpath(TEST_CASE_TABLE));
        if (testCaseTable.isElementPresent()){
            addTestCase();
            addTitleForCase();
            addType();
            addPriority();
            addSteps();
            clickOnCreateNewTestCase();
            setBreadcrumbsClick();
            setChooseATestCaseForDelete();
            clickOnDeleteButton();
            clickOnDeletePopUp();
        }else {
            addTestCase();
            addTitleForCase();
            addType();
            addPriority();
            addSteps();
            clickOnCreateNewTestCase();
            setBreadcrumbsClick();
            setChooseATestCaseForDelete();
            clickOnDeleteButton();
            clickOnDeletePopUp();
        }
    }
    @Step("TestCase6")
    public void testCase6(){
        productSelection();
        clickOnProductItem();
        clickOnTestCasePage();
        checkTestCaseTable();
    }

}

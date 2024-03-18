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

public class DeleteTestCasesFromProject extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final TextBox OPEN_TESTCASES_PAGE = new TextBox(By.xpath("//a[@id='navigation-suites']")) ;
    private static final TextBox TEST_CASE_TABLE = new TextBox(By.xpath("//div[@class='group grid-container']")) ;
    private static final TextBox CHOOSE_A_TEST_CASE_FOR_DELETE = new TextBox(By.xpath("//input[@class='selectionCheckbox']"));
    private static final Button DELETE_BUTTON = new Button(By.xpath("//a[@id='deleteCases']"));
    private static final Button DELETE_POP_UP = new Button(By.xpath("//div[@id='casesDeletionDialog']//div[@class='button-group dialog-buttons-highlighted']//a[@class='button button-left button-ok button-positive dialog-action-default' and @data-testid='deleteCaseDialogActionDefault']"));
    private static final Button ADD_TEST_CASES_BUTTON = new Button(By.xpath("//a[@id='sidebar-cases-add']"));
    private static final TextBox ADD_TITLE_FOR_TEST_CASES = new TextBox(By.xpath("//input[@class='form-control form-control-full form-fields ']"));
    private static final TextBox CLICK_ON_TYPE_LIST = new TextBox(By.xpath("//div[@id='type_id_chzn']//a"));
    private static final TextBox ADD_TYPE = new TextBox(By.xpath("//li[@id='type_id_chzn_o_" + (int) (Math.random() * 11) + "']"));
    private static final TextBox CLICK_ON_PRIORITY_LIST  = new TextBox(By.xpath("//div[@id='priority_id_chzn']"));
    private static final TextBox ADD_PRIORITY = new TextBox(By.xpath("//li[@id='priority_id_chzn_o_" +(int) Math.random() * 4 + "']"));
    private static final TextBox ADD_STEPS = new TextBox(By.xpath("//div[@id='custom_steps_display']"));
    private static final Button CREATE_TEST_CASE = new Button(By.xpath("//button[@id='accept']"));
    private static final TextBox BREADCRUMBS_CLICK = new TextBox(By.xpath("//div[@class='content-breadcrumb']//a"));
    public DeleteTestCasesFromProject() {
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
        OPEN_TESTCASES_PAGE.click();
    }
    @Step("Choose the test cases")
     public void setChooseATestCaseForDelete(){
        CHOOSE_A_TEST_CASE_FOR_DELETE.click();
    }
    @Step("Click on delete button ")
    public void clickOnDeleteButton(){
        DELETE_BUTTON.click();
    }
    @Step("Click on delete button in pop up")
    public void clickOnDeletePopUp(){
        DELETE_POP_UP.click();
    }
    @Step("Create a test case")
    public void addTestCase() {
        ADD_TEST_CASES_BUTTON.click();
    }
    @Step("Add title for test case")
    public void addTitleForCase() {
        ADD_TITLE_FOR_TEST_CASES.sendKeys(name);
    }
    @Step("Add type for test case")
    public void addType(){
        CLICK_ON_TYPE_LIST.click();
        ADD_TYPE.click();
    }
    @Step("Add priority for test case")
    public void addPriority(){
        CLICK_ON_PRIORITY_LIST.click();
        ADD_PRIORITY.click();
    }
    @Step("Add steps for test case")
    public void addSteps(){
        ADD_STEPS.scrollIntoView();
        ADD_STEPS.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rutrum dolor vitae luctus ");
    }
    @Step("Cleck on create button")
    public void clickOnCreateNewTestCase(){
        CREATE_TEST_CASE.scrollIntoView();
        CREATE_TEST_CASE.clickAndWait();
    }
    @Step("Click on breadcrumbs link  ")
    public void setBreadcrumbsClick(){
        BREADCRUMBS_CLICK.clickAndWait();
    }
    @Step("Check test case for delete")
    public void checkTestCaseTable(){
        if (TEST_CASE_TABLE.isElementPresent()){
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

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

public class CreateMalistoneForProject extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final TextBox GO_TO_MILESTONES = new TextBox(By.xpath("//a[@id='navigation-milestones']"));
    private static final Button ADD_NEW_MILESTONE = new Button(By.xpath("//a[@id='navigation-milestones-add']"));
    private static final TextBox SET_A_MILESTONE_NAME = new TextBox(By.xpath("//input[@class='form-control ' and @id='name']"));
    private static final TextBox SET_A_MILESTONE_REFERENCE = new TextBox(By.xpath("//input[ @id='reference']"));
    private static final TextBox SET_A_MILESTONE_DESCRIPTION = new TextBox(By.xpath("//div[ @id='description_display']"));
    private static final TextBox CLICK_ON_CALENDAR = new TextBox(By.xpath("//input[ @class='form-control form-control-small  dirty-trackable-datepicker hasDatepicker' and @id='start_on']"));
    private static final Button SET_A_START_DATE = new Button(By.xpath("//a[ @class='ui-state-default' and text()='21']"));
    private static final TextBox CLICK_ON_CALENDAR_END = new TextBox(By.xpath("//input[ @class='form-control form-control-small  dirty-trackable-datepicker hasDatepicker' and @id='due_on']"));
    private static final Button SET_A_END_DATE = new Button(By.xpath("//a[ @class='ui-state-default' and text()='31']"));
    private static final Button ADD_MILESTONE_BUTTON = new Button(By.xpath("//button[@id='accept']"));
    private static final TextBox SUCCES_MESSAGE = new TextBox(By.xpath("//div[@class='message message-success']"));

    public CreateMalistoneForProject() {
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
    @Step("Click on projecr")
    public void clickOnProductItem() {
        productItem.click();
    }
    @Step("Open milestone page")
    public void openMilestonesSection(){
        GO_TO_MILESTONES.click();
    }
    @Step("Click on AddNewMilestone button")
    public void addNewMilestone(){
        ADD_NEW_MILESTONE.click();
    }
    @Step("Fill the Milestones fields ")
    public void createAMilestone(){
        SET_A_MILESTONE_NAME.sendKeys(name);
        SET_A_MILESTONE_REFERENCE.sendKeys(name);
        SET_A_MILESTONE_DESCRIPTION.sendKeys(faker.chuckNorris().fact());
        CLICK_ON_CALENDAR.click();
        SET_A_START_DATE.click();
        CLICK_ON_CALENDAR_END.click();
        SET_A_END_DATE.click();

    }
    @Step("Create a new Millesone")
    public void addNewMilestoneButton(){
        ADD_MILESTONE_BUTTON.scrollIntoView();
        ADD_MILESTONE_BUTTON.click();
    }
    @Step("Check success creation")
    public void checkCreationMilestone(){
        softAssert.assertTrue(SUCCES_MESSAGE.isElementPresent(),
                "Report was create success");
    }
    @Step("TestCase4")
    public void testCase4(){
        productSelection();
        clickOnProductItem();
        openMilestonesSection();
        addNewMilestone();
        createAMilestone();
        addNewMilestoneButton();
        checkCreationMilestone();
        softAssert.assertAll();
    }

}

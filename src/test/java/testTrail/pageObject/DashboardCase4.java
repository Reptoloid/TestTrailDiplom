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

public class DashboardCase4 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final String GO_TO_MILESTONES = "//a[@id='navigation-milestones']";
    private static final String ADD_NEW_MILESTONE = "//a[@id='navigation-milestones-add']";
    private static final String SET_A_MILESTONE_NAME = "//input[@class='form-control ' and @id='name']";
    private static final String SET_A_MILESTONE_REFERENCE = "//input[ @id='reference']";
    private static final String SET_A_MILESTONE_DESCRIPTION = "//div[ @id='description_display']";
    private static final String CLICK_ON_CALENDAR = "//input[ @class='form-control form-control-small  dirty-trackable-datepicker hasDatepicker' and @id='start_on']";
    private static final String SET_A_START_DATE = "//a[ @class='ui-state-default' and text()='18']";
    private static final String CLICK_ON_CALENDAR_END = "//input[ @class='form-control form-control-small  dirty-trackable-datepicker hasDatepicker' and @id='due_on']";
    private static final String SET_A_END_DATE = "//a[ @class='ui-state-default' and text()='31']";
    private static final String ADD_MILESTONE_BUTTON = "//button[@id='accept']";
    private static final String SUCCES_MESSAGE = "//div[@class='message message-success']";

    public DashboardCase4() {
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
        TextBox clickOnMilestonesButton = new TextBox(By.xpath(GO_TO_MILESTONES));
        clickOnMilestonesButton.click();
    }
    @Step("Click on AddNewMilestone button")
    public void addNewMilestone(){
        Button addMilestoneButton = new Button(By.xpath(ADD_NEW_MILESTONE));
        addMilestoneButton.click();
    }
    @Step("Fill the Milestones fields ")
    public void createAMilestone(){
        TextBox setName = new TextBox(By.xpath(SET_A_MILESTONE_NAME));
        setName.sendKeys(name);
        TextBox setReference = new TextBox(By.xpath(SET_A_MILESTONE_REFERENCE));
        setReference.sendKeys(name);
        TextBox setDiscription = new TextBox(By.xpath(SET_A_MILESTONE_DESCRIPTION));
        setDiscription.sendKeys(faker.chuckNorris().fact());
        TextBox clickOnCalendar = new TextBox(By.xpath(CLICK_ON_CALENDAR));
        clickOnCalendar.click();
        Button setADate = new Button(By.xpath(SET_A_START_DATE));
        setADate.click();
        TextBox clickOnEndCalendar = new TextBox(By.xpath(CLICK_ON_CALENDAR_END));
        clickOnEndCalendar.click();
        Button setAEndDate = new Button(By.xpath(SET_A_END_DATE));
        setAEndDate.click();

    }
    @Step("Create a new Millesone")
    public void addNewMilestoneButton(){
        Button addMilestone = new Button(By.xpath(ADD_MILESTONE_BUTTON));
        addMilestone.scrollIntoView();
        addMilestone.click();
    }
    @Step("Check success creation")
    public void checkCreationMilestone(){
        TextBox checkMessage = new TextBox(By.xpath(SUCCES_MESSAGE));
        if(checkMessage.isElementPresent()){
            System.out.println("Milestone was successfully create");
        }else {
            System.out.println("Error");
        }
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
    }

}

package testTrail.pageObject;

import com.github.javafaker.Faker;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class CreateActivitySummaryReportForProject extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;

    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final TextBox OPEN_REPORT_PAGE = new TextBox(By.xpath("//a[@id='navigation-reports']"));
    private static final Button ACTIVITY_SUMMARY = new Button(By.xpath("//a[@class='link-noline link-tooltip' and @tooltip-text='Shows a summary of new and updated test cases.']"));
    private static final Button ADD_REPORT_BUTTON = new Button(By.xpath("//button[@id='submit']"));
    private static final TextBox SUCCESS_MESSAGE = new TextBox(By.xpath("//div[@class='message message-success']"));


    public CreateActivitySummaryReportForProject() {
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
    @Step("Open Report page")
    public void openReportPage(){
        OPEN_REPORT_PAGE.click();
    }
    @Step("Click on Activity Summary Report ")
    public void createActivitySummaryReport(){
        ACTIVITY_SUMMARY.click();
    }
    @Step("Create a Activity Summary Report ")
    public void clickAddReportButton(){
        ADD_REPORT_BUTTON.click();
    }
    @Step("Check success creation")
    public void checkReportCreation(){
        softAssert.assertTrue(SUCCESS_MESSAGE.isElementPresent(),
                "Report was create success");
    }
    @Step("TestCase7")
    public void testCase7(){
        productSelection();
        clickOnProductItem();
        openReportPage();
        createActivitySummaryReport();
        clickAddReportButton();
        checkReportCreation();
        softAssert.assertAll();
    }
}

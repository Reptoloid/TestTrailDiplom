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

public class DashboardCase7 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.lordOfTheRings().character();
    private WebElement productItem;
    public static String productName;
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='summary-title text-ppp']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());
    private static final String OPEN_PROJECT = "//div[@class='summary-title text-ppp']//a[text()='%s']";
    private static final String OPEN_REPORT_PAGE = "//a[@id='navigation-reports']";
    private static final String ACTIVITY_SUMMARY = "//a[@class='link-noline link-tooltip' and @tooltip-text='Shows a summary of new and updated test cases.']";
    private static final String ADD_REPORT_BUTTON = "//button[@id='submit']";
    private static final String SUCCESS_MESSAGE = "//div[@class='message message-success']";


    public DashboardCase7() {
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
        TextBox clickOnRepoertPageButton = new TextBox(By.xpath(OPEN_REPORT_PAGE));
        clickOnRepoertPageButton.click();
    }
    @Step("Click on Activity Summary Report ")
    public void createActivitySummaryReport(){
        Button createActivitySummaryReport = new Button(By.xpath(ACTIVITY_SUMMARY));
        createActivitySummaryReport.click();
    }
    @Step("Create a Activity Summary Report ")
    public void clickAddReportButton(){
        Button cliclAddReport = new Button(By.xpath(ADD_REPORT_BUTTON));
        cliclAddReport.click();
    }
    @Step("Check success creation")
    public void checkReportCreation(){
        TextBox successMessage = new TextBox(By.xpath(SUCCESS_MESSAGE));
        if (successMessage.isElementPresent()){
            System.out.println("Report was create success");
        }else {
            System.out.println("Error");
        }
    }
    @Step("TestCase7")
    public void testCase7(){
        productSelection();
        clickOnProductItem();
        openReportPage();
        createActivitySummaryReport();
        clickAddReportButton();
        checkReportCreation();
    }
}

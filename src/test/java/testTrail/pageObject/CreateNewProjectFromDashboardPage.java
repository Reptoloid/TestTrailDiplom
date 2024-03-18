package testTrail.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;

public class CreateNewProjectFromDashboardPage extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.chuckNorris().fact();
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final Button ADD_PROJECT_BUTTON = new Button(By.xpath("//a[@id='sidebar-projects-add']"));
    private static final TextBox NAME_FIELD = new TextBox(By.xpath("//input[@class='form-control ' and @id='name']"));
    private static final Button NEW_PROJECT_BUTTON = new Button(By.xpath("//button[@id='accept']"));
    private static final TextBox SUCCES_MESSAGE = new TextBox(By.xpath("//div[@class='message message-success']"));

    public CreateNewProjectFromDashboardPage() {
        super(By.xpath(PAGE_LOCATOR), "Dashboard");
    }
    @Step("Click on create new project button")
    public void clickOnAddProject() {
        ADD_PROJECT_BUTTON.click();
    }
    @Step("Set name for project")
    public void setProjectName() {
        NAME_FIELD.sendKeys(name);
    }
    @Step("Create a new project")
    public void clickOnCreateNewProject() {
        NEW_PROJECT_BUTTON.click();
    }
    @Step("Check creation")
    public void checkProjectCreation() {
        softAssert.assertTrue(SUCCES_MESSAGE.isElementPresent(),
                "Report was create success");
    }
    @Step("TestCase2")
    public void testCase2() {
        clickOnAddProject();
        setProjectName();
        clickOnCreateNewProject();
        checkProjectCreation();
    }

}

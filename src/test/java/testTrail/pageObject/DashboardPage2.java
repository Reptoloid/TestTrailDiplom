package testTrail.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class DashboardPage2 extends BasePage {
    static Faker faker = new Faker();
    static String name = faker.chuckNorris().fact();
    private static final String PAGE_LOCATOR = "//a[@id='navigation-dashboard']";
    private static final String ADD_PROJECT_BUTTON = "//a[@id='sidebar-projects-add']";
    private static final String NAME_FIELD = "//input[@class='form-control ' and @id='name']";
    private static final String NEW_PROJECT_BUTTON = "//button[@id='accept']";
    private static final String SUCCES_MESSAGE = "//div[@class='message message-success']";

    public DashboardPage2() {
        super(By.xpath(PAGE_LOCATOR), "Dashboard");
    }
    @Step("Click on create new project button")
    public void clickOnAddProject() {
        Button addProjectButton = new Button(By.xpath(ADD_PROJECT_BUTTON));
        addProjectButton.click();
    }
    @Step("Set name for project")
    public void setProjectName() {
        TextBox projectName = new TextBox(By.xpath(NAME_FIELD));
        projectName.sendKeys(name);
    }
    @Step("Create a new project")
    public void clickOnCreateNewProject() {
        Button clickOnButton = new Button(By.xpath(NEW_PROJECT_BUTTON));
        clickOnButton.click();
    }
    @Step("Check creation")
    public void checkProjectCreation() {
        TextBox succesMessage = new TextBox(By.xpath(SUCCES_MESSAGE));
        if (succesMessage.isElementPresent()) {
            System.out.println("Project was creating success");
        } else {
            System.out.println("Error");
        }
    }
    @Step("TestCase2")
    public void testCase2() {
        clickOnAddProject();
        setProjectName();
        clickOnCreateNewProject();
        checkProjectCreation();
    }

}

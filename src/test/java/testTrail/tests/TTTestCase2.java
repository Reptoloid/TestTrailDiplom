package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.CreateNewProjectFromDashboardPage;

public class TTTestCase2 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case2:Creating a new project")
    public void TestCase2(String email, String password) {
        setLogin(email,password);
        CreateNewProjectFromDashboardPage case2 = new CreateNewProjectFromDashboardPage();
        case2.testCase2();
    }
}

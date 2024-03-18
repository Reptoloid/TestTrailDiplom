package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.CreateNewTestCaseForProject;

public class TTTestCase3 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case3:Creating a test case")
    public void TestCase3(String email, String password){
        setLogin(email,password);
        CreateNewTestCaseForProject case3 = new CreateNewTestCaseForProject();
        case3.testCase3();
    }
}

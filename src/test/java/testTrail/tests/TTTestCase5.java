package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.CreateTestPlanForProject;

public class TTTestCase5 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case5:TestPlan creation ")
    public void TestCase5(String email, String password){
        setLogin(email,password);
        CreateTestPlanForProject case5 = new CreateTestPlanForProject();
        case5.testCase5();
    }
}

package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.CreateActivitySummaryReportForProject;

public class TTTestCase7 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case7:Create Activity Summary report ")
    public void TestCase7(String email, String password){
        setLogin(email,password);
        CreateActivitySummaryReportForProject case7 = new CreateActivitySummaryReportForProject();
        case7.testCase7();
    }

}

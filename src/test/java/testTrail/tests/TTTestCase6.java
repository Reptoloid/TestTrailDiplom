package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.DeleteTestCasesFromProject;

public class TTTestCase6 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case6:Delete TestCases ")
    public void TestCase6(String email, String password){
        setLogin(email,password);
        DeleteTestCasesFromProject case6 = new DeleteTestCasesFromProject();
        case6.testCase6();
    }
}

package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.CreateMalistoneForProject;

public class TTTestCase4 extends BaseTest {
    @Test
    @Parameters({"email", "password"})
    @Description("Case4:Melistone creation ")
    public void TestCase4(String email, String password){
        setLogin(email,password);
        CreateMalistoneForProject case4 = new CreateMalistoneForProject();
        case4.testCase4();
    }
}

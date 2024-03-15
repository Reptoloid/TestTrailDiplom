package testTrail.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testTrail.pageObject.*;

public class TTTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    @Description("Case1:Log in on page")
    public void TestCase1(String email, String password) {
        LoginPageCase1 loginPage = new LoginPageCase1();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickOnLoginButton();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case2:Creating a new project")
    public void TestCase2(String email, String password) {
        TestCase1(email,password);
        DashboardPage2 case2 = new DashboardPage2();
        case2.testCase2();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case3:Creating a test case")
    public void TestCase3(String email, String password){
        TestCase1(email,password);
        DashboardCase3 case3 = new DashboardCase3();
        case3.testCase3();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case4:Melistone creation ")
    public void TestCase4(String email, String password){
        TestCase1(email,password);
        DashboardCase4 case4 = new DashboardCase4();
        case4.testCase4();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case5:Melistone creation ")
    public void TestCase5(String email, String password){
        TestCase1(email,password);
        DashboardCase5 case5 = new DashboardCase5();
        case5.testCase5();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case6: Delete TestCases ")
    public void TestCase6(String email, String password){
        TestCase1(email,password);
        DashboardCase6 case6 = new DashboardCase6();
        case6.testCase6();
    }
    @Test
    @Parameters({"email", "password"})
    @Description("Case7: Create Activity Summary report ")
    public void TestCase7(String email, String password){
        TestCase1(email,password);
        DashboardCase7 case7 = new DashboardCase7();
        case7.testCase7();
    }

}


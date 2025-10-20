
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTest {
//    @BeforePackage
//    public void beforePackage(){
//        System.out.println("Before Package");
//    }
@BeforeSuite
public void beforeSuite(){
    System.out.println("beforeSuite");
}
    @BeforeTest
    public void firstTest() {
        System.out.println("Before Test");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    //beforeMethods will be executed before each ine every test methods
    @BeforeMethod
    public void beforeMethod() {
    System.out.println("Before Method");
    }

    @Test
    public void simpleTest() {
        System.out.println("Simple Test");

    }
    @Parameters({"URL"})
    @Test
    public void parameterizedTest(String URL) {
        System.out.println("Parameterized Test");
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
    }
    @Test
    public void testToBeHidden() {
        //it is hiden in xml file by using the methods->exlude
        System.out.println("Test To Be Hidden");
    }
    @AfterSuite
    public void afterSuite() {
    System.out.println("After Suite");
    }
    @AfterTest
    public void secondTest() {
        System.out.println("After Test");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

}

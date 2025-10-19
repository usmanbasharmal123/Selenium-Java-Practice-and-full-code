package TestNgPacageDayOne;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTestNg {

    public class LoginTests {

        @BeforeClass
        public void setup() {
            System.out.println("Setting up browser and environment");
        }

        @Test(priority = 1)
        public void testValidLogin() {
            System.out.println("Testing valid login scenario");
            // Add Selenium logic here
        }

        @Test(priority = 2)
        public void testInvalidLogin() {
            System.out.println("Testing invalid login scenario");
            // Add Selenium logic here
        }

        @Test(priority = 3)
        public void testEmptyCredentials() {
            System.out.println("Testing login with empty credentials");
            // Add Selenium logic here
        }

        @AfterClass
        public void teardown() {
            System.out.println("Closing browser and cleaning up");
        }
    }

}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TableSorting {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = initializeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sort-icon")));
            sortButton.click();

            // Capture the first column data after sorting
            List<WebElement> firstColumnElements = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
            List<String> originalList = firstColumnElements.stream()
                    .map(WebElement::getText)
                    .toList();

            System.out.println("Original Table Data:");
            originalList.forEach(System.out::println);

            // Create a sorted version of the original list
            List<String> sortedList = originalList.stream()
                    .sorted()
                    .toList();

            System.out.println("\nExpected Sorted Data:");
            sortedList.forEach(item -> System.out.println("→ " + item));

            // Assertion to verify the table is sorted correctly
            Assert.assertEquals(originalList, sortedList, "Table is not sorted as expected!");

            System.out.println("\n✅ Table sorting validation passed.");

        } catch (Exception e) {
            System.err.println("❌ Test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); // Always close the browser
            }
        }
    }

    private static WebDriver initializeDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitPractice {
    public static void main(String[] args) throws InterruptedException {
        // Setup Firefox driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
//
        driver.findElement(By.className("cart-icon")).click();
//        Thread.sleep(4000);

    }




}

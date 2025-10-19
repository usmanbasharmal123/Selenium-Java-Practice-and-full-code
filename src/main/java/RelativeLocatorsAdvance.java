import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
public class RelativeLocatorsAdvance {
    public static void main(String[] args) throws IOException {
        WebDriver driver=webDriver();;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement element=driver.findElement(By.id("search-field"));
        System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(element)).getText());



    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

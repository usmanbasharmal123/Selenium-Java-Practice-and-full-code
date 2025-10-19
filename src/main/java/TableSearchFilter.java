import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TableSearchFilter {
    public static void main(String[] args){
    WebDriver driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String item="rice";
        driver.findElement(By.id("search-field")).sendKeys(item);
        List<WebElement>tblData= driver.findElements(By.xpath("//tr//td[1]"));
       List<WebElement> result= tblData.stream().filter(el->el.getText().equalsIgnoreCase(item)).toList();
        Assert.assertFalse(result.isEmpty(), "No results found " + item);
       Assert.assertTrue(result.stream().anyMatch(el->el.getText().equalsIgnoreCase(item)), "No results found " + item);
    }
    private static WebDriver initializeDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}

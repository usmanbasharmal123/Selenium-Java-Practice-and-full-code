import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().minimize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//header/div/a")).click();
        Thread.sleep(5000);
        driver.navigate().back();

//        driver.findElement(By.xpath("//header/div/button[text()='Practice']/following-sibling::button[1]")).click();
//        driver.findElement(By.xpath("//button[text()='Practice']/following-sibling::button[1]")).click();
    }
}

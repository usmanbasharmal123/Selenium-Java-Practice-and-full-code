import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class NewWindwo {
    public static void main(String[] args) throws IOException {
        WebDriver driver=webDriver();
        driver.get("https://www.google.com");
       String parentId = driver.getWindowHandle();
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
       String childId="";
       Set<String> allWindowHandles = driver.getWindowHandles();
       for (String handle : allWindowHandles) {
           if(!handle.equals(parentId)) {
               childId=handle;
           }
       }

           driver.switchTo().window(childId);
       String textOf=driver.findElement(By.cssSelector("[for='search-field']")).getText();
       driver.close();
           driver.switchTo().window(parentId);
           driver.findElement(By.id("APjFqb")).sendKeys(textOf);


    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

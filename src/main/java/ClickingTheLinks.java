import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClickingTheLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = webDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement tblSection = driver.findElement(By.cssSelector("table.gf-t td:nth-child(1) ul"));
        List<WebElement> links=tblSection.findElements(By.tagName("a"));

        for (WebElement link:links){
            String linkClickInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
            link.sendKeys(linkClickInNewTab);
            Thread.sleep(5000);
        }
        getChildWindowId(driver);

    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
    public static void getChildWindowId(WebDriver driver){

        Set<String> allWindows=driver.getWindowHandles();//
        for(String windowId:allWindows){
            driver.switchTo().window(windowId);
            System.out.println(driver.getTitle());
        }

    }





}

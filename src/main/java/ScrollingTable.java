import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.internal.thread.ThreadExecutionException;

import java.time.Duration;
import java.util.List;

public class ScrollingTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=webDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> tbData = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
        int sum=0;
        for(WebElement data:tbData){
            System.out.println(data.getText());
            sum+=Integer.parseInt(data.getText());

        }
        String totalAmount=driver.findElement(By.cssSelector(".totalAmount")).getText();
        String totalS = totalAmount.split(":")[1].trim();
        int total = Integer.parseInt(totalS);
        Assert.assertEquals(total,sum);
        System.out.println("Actual Amount is = "+total+ " and resutl in here is " +sum);





    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

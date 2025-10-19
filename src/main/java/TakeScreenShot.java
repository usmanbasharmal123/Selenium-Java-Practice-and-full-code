import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;


import java.io.IOException;
import java.time.Duration;

public class TakeScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver=webDriver();
        driver.get("https://www.google.com");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("K://a.png"));

        //if you want to take screenshot of element is like below
        WebElement element= driver.findElement(By.id("txtName"));
        File src2=element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src2,new File("K://b.png"));

    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

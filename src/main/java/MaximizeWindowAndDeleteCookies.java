import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MaximizeWindowAndDeleteCookies {
    public void maximizeWindowAndDeleteCookies(){
        WebDriver driver=webDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        //delete all cookies
        driver.manage().deleteAllCookies();
        //delete cookies by name
        driver.manage().deleteCookieNamed("JSESSIONID");
    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

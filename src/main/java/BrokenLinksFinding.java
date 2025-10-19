import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class BrokenLinksFinding {
    public static void main(String[] args) throws MalformedURLException, IOException {
      WebDriver driver = setDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links= driver.findElements(By.cssSelector("#gf-BIG a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link : links) {
            String url=link.getAttribute("href");
            HttpURLConnection con= (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
          int responseCode=  con.getResponseCode();
          softAssert.assertTrue(responseCode<400,"This Links is broken "+link.getAttribute("href") +" and the Code is "+responseCode );


        }
        softAssert.assertAll();

    }
    public static WebDriver setDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

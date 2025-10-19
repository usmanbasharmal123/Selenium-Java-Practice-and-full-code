import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class ChromeOption {
    public static void main(String[] args) {
         WebDriver driver= webDriver();

    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();
        //inbleing SSL certificaiton
        FirefoxOptions options= new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        //set proxy
        Proxy proxy= new Proxy();
        proxy.setHttpProxy("iptiddres::4444");
        options.setCapability("proxy",proxy);
        WebDriver driver=new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

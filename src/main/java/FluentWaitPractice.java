import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        driver.get("https://amazon.com");
        driver.findElement(By.cssSelector("div#start button")).click();
        Wait<WebDriver>wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        String textR = wait.until(d->{
          WebElement element=  d.findElement(By.cssSelector("#finish h4"));
          return element.isDisplayed()?element:null;
        }).getText();
        String result = textR==null?"Your result is emapty":textR;
        System.out.println(result);

    }
}

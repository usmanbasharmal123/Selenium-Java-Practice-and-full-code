import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionPractice {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        driver.findElement(By.className("a-button-text")).click();
//to perform the simple move mouse or mouse over action
       actions.moveToElement(driver.findElement(By.cssSelector("div#nav-link-accountList"))).perform();
// to perform the double click action
        actions.doubleClick(driver.findElement(By.className("icp-nav-link-inner"))).perform();
    // how to select the text in the textbox using doubleclick action
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("shirt").doubleClick().perform();
/// how to make the letter to uppercase in searchbox
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("shirt").perform();
//How to Right click note we will use the contextCleick()
        actions.contextClick(driver.findElement(By.className("icp-nav-link-inner"))).perform();
    }


}

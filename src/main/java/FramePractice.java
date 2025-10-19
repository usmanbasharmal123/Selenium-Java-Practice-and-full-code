import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FramePractice {
    public static void main(String[] args) {

   WebDriverManager.firefoxdriver().setup();
   WebDriver driver = new FirefoxDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   driver.get("https://jqueryui.com/droppable");
   WebElement frame = driver.findElement(By.className("demo-frame"));
   driver.switchTo().frame(frame);
   WebElement sourceElement = driver.findElement(By.id("draggable"));
   WebElement targetElement = driver.findElement(By.id("droppable"));
   Actions actions = new Actions(driver);
   actions.dragAndDrop(sourceElement, targetElement).perform();
   // we have to come out of the frame if we want to perform the action outside the frame
   driver.switchTo().defaultContent();

    }

}



//public class FramePractice {
//    public static void main(String[] args) {
//        try{
//            WebDriver driver = webDriver();
//            driver.get("https://jqueryui.com/droppable");
//            getFrame(driver);
//            performActions(driver,By.id("draggable"),By.id("droppable"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
////            driver.quit();
//        }
//
//
//
//
//    }
//    public static WebDriver webDriver(){
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver= new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        return driver;
//    }
//    public static void getFrame(WebDriver driver){
//        WebElement frameElement = driver.findElement(By.className("demo-frame"));
//        driver.switchTo().frame(frameElement);
//
//    }
//    public static void performActions(WebDriver driver,By source,By target){
//        WebElement sourceElement = driver.findElement(source);
//        WebElement targetElement = driver.findElement(target);
//        new Actions(driver).dragAndDrop(sourceElement,targetElement).perform();
//    }
//}

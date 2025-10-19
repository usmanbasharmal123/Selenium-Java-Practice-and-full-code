import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ActionHandleWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        try{
            driver.get("https://rahulshettyacademy.com/loginpagePractise");
            //get the Parentwindow id
            String parentWindowId = driver.getWindowHandle();
            //click on child window button
            driver.findElement(By.className("blinkingText")).click();
            //get the child window id
            String childWindowId = getChildWindowId(driver,parentWindowId);
            driver.switchTo().window(childWindowId);
            String email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red a"))).getText();
            driver.switchTo().window(parentWindowId);
            driver.findElement(By.id("username")).sendKeys(email);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
//            driver.quit();
        }
            }
    private static String getChildWindowId(WebDriver driver,String parentWindowId){
        Set<String>allWindows= driver.getWindowHandles();
        //check if you are in the right child window
        for(String windowId:allWindows){
            if(!windowId.equals(parentWindowId)){
                return windowId;
            }
        }
            throw new RuntimeException("You are not in the child window");
    }

}




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPractice {
    public static void main(String[] args) {
        // Setup Firefox driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        try{
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            alert.dismiss();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            driver.quit();

        }
    }
}

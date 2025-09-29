import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AutoSugestingDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(3000);
       List<WebElement> options =driver.findElements(By.cssSelector(".ui-menu-item a"));
        for(WebElement option:options){
           if(option.getText().equalsIgnoreCase("India")){
               option.click();
               break;
           }

        }
    }
}

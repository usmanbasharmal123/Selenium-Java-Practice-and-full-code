import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropDownClicked =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown= new Select(dropDownClicked);
        dropdown.selectByValue("USD");
        dropdown.getFirstSelectedOption();
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}

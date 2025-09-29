import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsToCart {
    public static void main(String[] args) throws InterruptedException {
        // Setup Firefox driver
     WebDriverManager.firefoxdriver().setup();
     WebDriver driver = new FirefoxDriver();
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
     driver.get("https://rahulshettyacademy.com/seleniumPractise");
//     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     List<String> itemsAddToCart = new ArrayList<>(Arrays.asList("Cauliflower","Cucumber","Beetroot"));
        AddItemsToCartF(driver,itemsAddToCart,wait);
        driver.findElement(By.className("cart-icon")).click();
//        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-block button"))).click();
//        driver.findElement(By.cssSelector(".action-block button")).click();
//        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode"))).sendKeys("rahulshettyacademy");
//        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
//        Thread.sleep(4000);
        WebElement promoInfoText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        if(promoInfoText.isDisplayed()){
            System.out.println(driver.findElement(By.className("promoInfo")).getText());
            driver.findElement(By.xpath("//button[text()='Place Order']")).click();
            driver.findElement(By.className("chkAgree")).click();
            driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        }

    }
    public static void AddItemsToCartF(WebDriver driver,List<String>itemsAddToCart,WebDriverWait wait) {
         List<WebElement>products=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.product-name")));
        List<WebElement>addToCartButton=driver.findElements(By.cssSelector(".product-action button"));
        int addToCartCount=0;
        for (int i=0;i<products.size();i++) {
            String fullName = products.get(i).getText();
            String itemName = fullName.split(" ")[0].trim();

            if (itemsAddToCart.contains(itemName)) {
                addToCartButton.get(i).click();
                addToCartCount++;
                if(addToCartCount==itemsAddToCart.size()) {
                    break;
                }
            }

        }
    }
}

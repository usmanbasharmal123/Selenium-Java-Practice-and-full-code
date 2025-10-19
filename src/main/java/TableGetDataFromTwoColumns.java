import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class TableGetDataFromTwoColumns {

    public static void main(String[] args) {
        WebDriver driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String itemName = "Beans";
        List<String> prices = getPriceForItem(driver, itemName);

        if (prices.isEmpty()) {
            System.out.println("Item not found: " + itemName);
        } else {
            prices.forEach(price -> System.out.println("Price of " + itemName + ": " + price));
        }

        driver.quit();
    }

    private static List<String> getPriceForItem(WebDriver driver, String itemName) {
        List<String> prices;
        int maxAttempts = 10;
        int attempts = 0;

        do {
            List<WebElement> rows = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
            prices = rows.stream()
                    .filter(item -> item.getText().equalsIgnoreCase(itemName))
                    .map(TableGetDataFromTwoColumns::getPrice)
                    .toList();

            if (prices.isEmpty()) {
                WebElement nextButton = driver.findElement(By.cssSelector("[aria-label='Next']"));
                if (nextButton.getAttribute("class").contains("disabled")) break;
                nextButton.click();
                attempts++;
            }

        } while (prices.isEmpty() && attempts < maxAttempts);

        return prices;
    }

    private static String getPrice(WebElement element) {
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    private static WebDriver initializeDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}

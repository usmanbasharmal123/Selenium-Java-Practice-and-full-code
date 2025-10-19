import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LinkConts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = webDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        //get the total count of links in whole page
        int allCountListInPage=driver.findElements(By.tagName("a")).size();
        //count the link in the footer page
        int countLinks=driver.findElements(By.cssSelector("#gf-BIG a")).size();
        //professional way of doing the clicking the links
        WebElement tblSection = driver.findElement(By.xpath("//table[@class='gf-t']//td[1]/ul"));
        List<WebElement> links=tblSection.findElements(By.tagName("a"));
//             System.out.println(countLinks);
//System.out.println(allCountListInPage);

for(int i=0;i<links.size();i++){

    String linkClickInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
    links.get(i).sendKeys(linkClickInNewTab);
}

    }
    public static WebDriver webDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
}


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Locator2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector(".forgot-pwd-container a")).click();
//        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
//        Thread.sleep(3000);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        String textMessage = driver.findElement(By.className("infoMsg")).getText();
        String finalMessage="";
        if(textMessage.contains("'")){
            String[]result=textMessage.split("'");
            if(result.length>=2){
                finalMessage=result[1];
            }
        }
//        Pattern pattern = Pattern.compile("'(.*?)'");
//        Matcher matcher = pattern.matcher(textMessage);
//
//        if (matcher.find()) {
//            finalMessage = matcher.group(1);
//        }
        String a =(textMessage.split("'")[1]).split("'")[0];
        System.out.println(finalMessage);
    }
}

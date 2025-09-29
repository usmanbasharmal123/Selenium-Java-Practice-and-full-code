package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String userName="rahul";
        driver.findElement(By.id("inputUsername")).sendKeys("Jan");
        driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("passwodM");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[@class=\"submit signInBtn\"]")).click();
//       System.out.println( driver.findElement(By.cssSelector("p.error")).getText());
       driver.findElement(By.cssSelector(".forgot-pwd-container a")).click();
//       Thread.sleep(1000);
        driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("rahul");
      driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("youremai.com");
      Thread.sleep(5000);
     driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
     String textMessage = driver.findElement(By.className("infoMsg")).getText();
     driver.findElement(By.className("go-to-login-btn")).click();
     Thread.sleep(1000);
     driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
String successMsg =driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
driver.findElement(By.xpath("//button[text()='Log Out']")).click();
//        driver.findElement(By.cssSelector("button[text()='Log Out']")).click();

     Assert.assertEquals(successMsg, "You are successfully logged in.");

//     ArrayList<String> passWord = textMessage.split(" ","");
     System.out.println(successMsg);


    }}

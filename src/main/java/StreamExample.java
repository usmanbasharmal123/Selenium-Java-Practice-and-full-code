import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws InterruptedException {

        List<String> names= new ArrayList<>(Arrays.asList("Ahmad","Mehmood","Jan","Bashar","Khalid","Ali","Amir"));
        List<String> names2= new ArrayList<>(Arrays.asList("Gul","Babo","Arshid"));
        //code strat from here
//        int nameCount=0;
//        for(int i=0;i<names.size();i++){
//         String namelast =names.get(i);
//     if(names.get(i).startsWith("A")){
//
//         nameCount++;
//     }
//        }
//        System.out.println(nameCount);
        //By the help of Stream we can do the below above operation like below
//        long nameCount =names.stream().filter(name->name.startsWith("A")).count();

//        System.out.println(nameCount);

        //or we can do this using Stream.of()
//        long nameCount= Stream.of("Ahmad","Mehmood","Jan","Bashar","Khalid","Ali","Amir").filter(name->name.startsWith("A")).count();
//        System.out.println(nameCount);

        //give me thenames which are more than 4 letters
//        List<String> names= new ArrayList<>(Arrays.asList("Ahmad","Mehmood","Jan","Bashar","Khalid","Ali","Amir"));
        // give me the first name from the list which are graterh than 4 charectors
//        names.stream().filter(name->name.length()>4).map(name->name.toUpperCase()).limit(1).forEach(System.out::println);
        // print me all name in upper case and sort it
//        names.stream().map(name->name.toUpperCase()).sorted().forEach(System.out::println);
        // print me all name in decending order by default it is accending order
//        names.stream().filter(name->name.startsWith("A")).sorted(Comparator.reverseOrder()).forEach(System.out::println);
//  //concotanate two lists using streams
//        Stream<String>concatenatedStreams=Stream.concat(names.stream(),names2.stream());
//        concatenatedStreams.forEach(System.out::println);
//check if the ALi is existed in the list
//        boolean check=names.stream().anyMatch(name->name.equalsIgnoreCase("Ali"));
//        Assert.assertTrue(check);
//        System.out.println(check);
        //get the list do manipulation and return a new list for example I want the names started with A in new list
//        List<String> names= new ArrayList<>(Arrays.asList("Ahmad","Mehmood","Jan","Bashar","Khalid","Ali","Amir"));
//       List<String>namesStartedWithA= names.stream().filter(name->name.contains("A")).toList();
//        System.out.println(namesStartedWithA);
        //Remove the duplicate values
//        List<Integer> numbers= Arrays.asList(1,2,2,3,3,4,5);
//        List<Integer> numbers= Arrays.asList(1,2,2,3,3,4,5);
        List<Integer>numbers2= new ArrayList<>(Arrays.asList(1,4,1,2,2,3,3,4,5));
        List<Integer>distinctNumber= numbers2.stream().distinct().sorted().toList();
        //get me the index number 3 data from list
        System.out.println(distinctNumber.get(3));

    }

    public static WebDriver setDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

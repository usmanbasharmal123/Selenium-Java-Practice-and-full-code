import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParentClassAnimal {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }
    public void eat(){
        System.out.println("I am eating");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

}

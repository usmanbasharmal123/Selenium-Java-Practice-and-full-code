import org.testng.annotations.Test;

public class DependencyTest {
    //as per te execution rules the testA will be executed before TestB
    //I want to run the thest B before testA how do I do
    @Test(dependsOnMethods ={"TestB"} )
    public void TestA() {
        System.out.println("Test A");
    }
    @Test
    public void TestB() {
        System.out.println("Test B");
    }
    //wait uppto 40 second
    @Test(timeOut = 4000)
    public void TestC() {
        System.out.println("Test Timeout");
    }
}

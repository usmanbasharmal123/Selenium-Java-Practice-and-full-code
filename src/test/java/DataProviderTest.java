import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider ="getData")
    public void MobileLoginTest(String username, String password) {
        System.out.println("MobileLoginTest");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }
    @DataProvider
    private Object[][] getData() {
        return new Object[][]{
                {"firstUser", "firstPassword"},
                {"secondUser", "secondPassword"},
                {"thirdUser", "thirdPassword"}
        };
    }
//    public Object[][] getData(){
//        Object[][] data = new Object[3][2];
////        first set
//        data[0][0]="firstUsername";
//        data[0][1]="firstPassword";
////second set
//        data[1][0]="secondUsername";
//        data[1][1]="secondPassword";
////thirt set
//        data[2][0]="thirdUsername";
//        data[2][1]="thirdPassword";
//        return data;
//    }


}

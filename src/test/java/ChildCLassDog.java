import org.testng.annotations.Test;

public class ChildCLassDog extends  ParentClassAnimal {
    ParentClassWithConstructor pCC = new ParentClassWithConstructor(4); //parametarized constructor
    @Test
    public void callDecrementOrIncrement(){
        System.out.println(pCC.decrement());
        System.out.println(pCC.increment());
        System.out.println(pCC.multiplication());
    }
  @Test
    public void eatTest(){
      eat();
  }


}


public class ParentClassWithConstructor extends GrandParentCLass {
    int value;   //this is class variable
    public ParentClassWithConstructor(int v){
        super(v);
        this.value=v;
        //in the above the variable is instance variable
    }
    public int increment(){
        value=value+1;
        return value;
    }
    public int decrement(){
        value=value-1;
        return value;
    }
}

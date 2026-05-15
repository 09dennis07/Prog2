package annotations;

@MyMarker
public class AnnotatedClass extends BaseClass {

    @Deprecated
    public void oldMethod() {};
    
    /*
    @Override
    public void doIt() { };
    */

    /*
    @Override
    public void doesNotExist() {} 
    */
    
    @MyMarker
    public void myMethod1() {
    }
    
    @MyComment ("usage of this method is dangerous")
    public void myMethod2() {
    }
    
    @Authors ({"Alf", "Sally"})
    public void myMethod3() {
    }
    
    @ToDo (what="execute", count=3)
    public void myMethod4() {
    }
    
    @Reviewer(@Name(first = "Joe", last = "Hacker"))
    public void myMethod5() {
    }
    
    @Deprecated
    public void executeMe() {
    	System.out.println("Method executeMe() was called!");
    }
    
    @ToBeExecuted(param=3)
    public void executeMe(int param) {
    	System.out.println("Method executeMe(int) was called: " + param);
    }
    
    public static void main(String[] args) {
        AnnotatedClass ac = new AnnotatedClass();
        ac.oldMethod();
    }
}

package other.proxy.dynamicjdk;


public class HelloImpl implements Hello {

    @Override
    public void sayHi() {
        System.out.println("hello.");
    }
}

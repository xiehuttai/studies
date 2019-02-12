package structure._06facade;

/**
 * 外观/门面 facade模式，统一入口，简化交互
 */
public class Main {

    public static void main(String[] args) {
        AbstractFacade facade = new Facade();
        facade.doIt();
    }

}


abstract class AbstractFacade{

    protected SystemA systemA = new SystemA();
    protected SystemB systemB = new SystemB();
    protected SystemC systemC = new SystemC();

    abstract void doIt();

}


class Facade extends AbstractFacade{

    @Override
    void doIt() {
        systemA.doIt();
        systemB.doIt();
        systemC.doIt();
    }
}

class SystemA{
    void doIt(){
        System.out.println("system a do.");
    }
}

class SystemB{
    void doIt(){
        System.out.println("system b do.");
    }
}

class SystemC{
    void doIt(){
        System.out.println("system c do.");
    }
}
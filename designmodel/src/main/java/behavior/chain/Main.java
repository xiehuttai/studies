package behavior.chain;

/**
 * 责任链模式,请求的链式处理
 */
public class Main {

    public static void main(String[] args) {

        Handler a = new A();
        Handler b = new B();
        Handler c = new C();
        Handler d = new D();

        a.setNextHandler(b);
        b.setNextHandler(c);
        c.setNextHandler(d);


        a.doIt(1);
        a.doIt(11);
        a.doIt(111);
        a.doIt(1111);

    }

}


abstract class Handler{

    Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }


    abstract void doIt(int num);

}


class A extends Handler{
    @Override
    void doIt(int num) {
        if (num<=10)
            System.out.println("a doIt : "+num);
        else
            nextHandler.doIt(num);
    }
}

class B extends Handler{
    @Override
    void doIt(int num) {
        if (num<=100)
            System.out.println("b doIt : "+num);
        else
            nextHandler.doIt(num);
    }
}

class C extends Handler{
    @Override
    void doIt(int num) {
        if (num<=1000)
            System.out.println("c doIt : "+num);
        else
            nextHandler.doIt(num);
    }
}

class D extends Handler{
    @Override
    void doIt(int num) {
        System.out.println("d doIt : "+num);
    }
}
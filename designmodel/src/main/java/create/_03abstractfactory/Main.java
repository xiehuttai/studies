package create._03abstractfactory;

public class Main {

    public static void main(String[] args) {

        Factory factory ;

        /**
         * 产品族
         */
        Tv tv;
        Light light ;


        /**
         * 种类
         */
        /**
         * haier
         */
        factory = new HaierFactory();
        tv = factory.createTv();
        light = factory.createLight();
        tv.whatTv();
        light.whatLight();

        /**
         * tcl
         */
        factory = new TclFactory();
        tv = factory.createTv();
        light = factory.createLight();
        tv.whatTv();
        light.whatLight();

    }

}

interface Factory{
     Tv createTv();
     Light createLight();
}


interface  Tv{
    void whatTv();
}

interface  Light{
    void whatLight();
}

class HaierFactory implements Factory{
    @Override
    public Tv createTv() {
        return new HaierTv();
    }

    @Override
    public Light createLight() {
        return new HaierLight();
    }
}

class HaierTv implements Tv{
    @Override
    public void whatTv() {
        System.out.println(HaierTv.class.getName());
    }
}

class HaierLight implements Light{
    @Override
    public void whatLight() {
        System.out.println(HaierLight.class.getName());
    }
}

class TclFactory implements Factory{
    @Override
    public Tv createTv() {
        return new TclTv();
    }

    @Override
    public Light createLight() {
        return new TclLight();
    }
}

class TclTv implements  Tv{
    @Override
    public void whatTv() {
        System.out.println(TclTv.class.getName());
    }
}

class TclLight implements Light{
    @Override
    public void whatLight() {
        System.out.println(TclLight.class.getName());
    }
}

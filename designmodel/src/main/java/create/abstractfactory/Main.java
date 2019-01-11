package create.abstractfactory;

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

abstract class Factory{
    abstract Tv createTv();
    abstract Light createLight();
}


abstract class Tv{
    abstract void whatTv();
}

abstract class Light{
    abstract void whatLight();
}

class HaierFactory extends Factory{
    @Override
    Tv createTv() {
        return new HaierTv();
    }

    @Override
    Light createLight() {
        return new HaierLight();
    }
}

class HaierTv extends Tv{
    @Override
    void whatTv() {
        System.out.println(HaierTv.class.getName());
    }
}

class HaierLight extends Light{
    @Override
    void whatLight() {
        System.out.println(HaierLight.class.getName());
    }
}

class TclFactory extends Factory{
    @Override
    Tv createTv() {
        return new TclTv();
    }

    @Override
    Light createLight() {
        return new TclLight();
    }
}

class TclTv extends  Tv{
    @Override
    void whatTv() {
        System.out.println(TclTv.class.getName());
    }
}

class TclLight extends Light{
    @Override
    void whatLight() {
        System.out.println(TclLight.class.getName());
    }
}

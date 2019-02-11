package structure.decorator;


/**
 * 抽象构件
 */
public interface ICar {
    void move();
}


/**
 * 具体构件
 */
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("on load ");
    }

}


/**
 * 抽象装饰
 */
class SuperCar implements ICar{

    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
      car.move();
    }

}


/**
 * 真实装饰对象
 */
class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("on sky ");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim(){
        System.out.println("on water ");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}


class AICar extends SuperCar{

    public AICar(ICar car) {
        super(car);
    }

    public void ai(){
        System.out.println("auto run ");
    }

    @Override
    public void move() {
        super.move();
        ai();
    }
}
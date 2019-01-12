package structure.decorator;

/*jdk实现 ： io */
public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.move();

        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        FlyCar flyCar = new FlyCar(waterCar);
        flyCar.move();

        AICar aiCar = new AICar(flyCar);
        aiCar.move();

    }

}

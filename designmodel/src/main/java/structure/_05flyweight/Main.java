package structure._05flyweight;

import java.util.HashMap;
import java.util.Map;


/**
 * 享元/轻量级 flyweight 模式，共享相似对象
 */
public class Main {

    static String videoKey="video";
    static String imageKey="image";

    public static void main(String[] args) {


        FlyWeightFactory factory = FlyWeightFactory.getInstance();
        FlyWeight video1 = factory.getFlyWeight(videoKey);
        FlyWeight video2 = factory.getFlyWeight(videoKey);

        System.out.println(video1.equals(video2));
        video1.display(new Coordinates(1,1));

        FlyWeight image1 = factory.getFlyWeight(imageKey);
        FlyWeight image2 = factory.getFlyWeight(imageKey);

        System.out.println(image1.equals(image2));
        image1.display(new Coordinates(2,1));

    }

}


class Coordinates{

    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x:"+x+",y:"+y;
    }
}

abstract class FlyWeight{

    abstract void display(Coordinates coordinates);

}

class VideoFlyWeight extends  FlyWeight{

    @Override
    void display(Coordinates coordinates) {
        System.out.println("video" + coordinates);
    }

}


class ImageFlyWeight extends  FlyWeight{

    @Override
    void display(Coordinates coordinates) {
        System.out.println("image" + coordinates);
    }

}

class FlyWeightFactory {

    private FlyWeightFactory(){
    }

    private static class Holder{
        private static final FlyWeightFactory instance=new FlyWeightFactory();
    }

    public static FlyWeightFactory getInstance(){
        return Holder.instance;
    }

    Map<String,FlyWeight> flyWeights= new HashMap<>();

    public FlyWeight getFlyWeight(String key) {
        FlyWeight flyWeight = flyWeights.get(key);
        if (flyWeight==null)
            if (key.equals("video")) {
                flyWeight = new VideoFlyWeight();
                flyWeights.put(key,flyWeight);
            }else if(key.equals("image")) {
                flyWeight = new ImageFlyWeight();
                flyWeights.put(key,flyWeight);
            }
        return flyWeight ;
    }
}
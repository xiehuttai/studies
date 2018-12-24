package clone;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample cloneExample = new CloneExample();
        Object clone = cloneExample.clone();
    }

}

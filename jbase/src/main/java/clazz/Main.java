package clazz;

public class Main {

    public static void main(String[] args) {
        String typeName = Main.class.getTypeName();
        System.out.println(typeName);
        String name = Main.class.getName();
        System.out.println(name);
        String simpleName = Main.class.getSimpleName();
        System.out.println(simpleName);
    }

}

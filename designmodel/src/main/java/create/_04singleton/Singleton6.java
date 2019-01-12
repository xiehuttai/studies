package create._04singleton;

public class Singleton6 {

    private Singleton6(){}

    private static class Holder {
        private final static Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6  getInstance(){
        return  Holder.INSTANCE;
    }

}

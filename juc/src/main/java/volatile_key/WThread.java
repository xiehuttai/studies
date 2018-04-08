package volatile_key;

public class WThread extends Thread {

    VolatileExample v;

    public WThread(VolatileExample v) {
        this.v = v;
    }

    @Override
    public void run() {
        v.writer();

    }

}

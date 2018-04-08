package volatile_key;

public class RThread extends Thread {

    VolatileExample v;

    public RThread(VolatileExample v) {
        this.v = v;
    }

    @Override
    public void run() {
        v.reader();
    }

}

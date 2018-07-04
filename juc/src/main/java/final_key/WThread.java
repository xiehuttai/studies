package final_key;


public class WThread extends Thread {

    FinalExample f;

    public WThread(FinalExample f) {
        this.f = f;
    }

    @Override
    public void run() {
        f.writer();

    }

}

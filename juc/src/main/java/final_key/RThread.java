package final_key;

import volatile_key.VolatileExample;

public class RThread extends Thread {

    FinalExample f;

    public RThread(FinalExample f) {
        this.f = f;
    }

    @Override
    public void run() {
        f.reader();
    }

}

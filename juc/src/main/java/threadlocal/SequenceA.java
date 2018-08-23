package threadlocal;

public class SequenceA implements Sequence {

    private static int number=0;

    @Override
    public int getNumber() {
        return ++number;
    }

}

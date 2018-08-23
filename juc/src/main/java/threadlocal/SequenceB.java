package threadlocal;

public class SequenceB implements Sequence {

    private static ThreadLocal<Integer> number= new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        number.set(number.get()+1);;
        return number.get();
    }
}

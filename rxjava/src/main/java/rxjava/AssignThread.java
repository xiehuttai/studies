package rxjava;

import io.reactivex.Observable;

public class AssignThread {

    public static void main(String[] args) {

        Observable.just("A","B","C")
//                .observeOn(Schedulers.newThread()) 这里暂时没搞懂
//                .subscribeOn(Schedulers.io())
                .subscribe(
                        event-> System.out.println("what event is : "+ event + " "+ Thread.currentThread())
                );
    }

}

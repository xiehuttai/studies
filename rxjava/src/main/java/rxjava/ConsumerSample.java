package rxjava;

import io.reactivex.Observable;

public class ConsumerSample {

    public static void main(String[] args) {
        Observable.just("event 1","event 2","event 3","event 4").subscribe(
                /**
                 * Consumer accept 简化的观察者对象
                 */
                event -> System.out.println("whatIs : " + event)
        );
    }
}

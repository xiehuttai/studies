package rxjava;

import io.reactivex.Observable;

/**
 * 映射被观察者事件
 */
public class MapSample {

    public static void main(String[] args) {
        Observable.just("event x","event xx","event xxx")
                /**
                 * map 事件事件
                 */
                .map(
                        event-> event.length()-6
                )
                .subscribe(
                length -> System.out.println("whatIs length : " + length)
        );
    }
}

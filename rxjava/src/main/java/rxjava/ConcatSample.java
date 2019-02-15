package rxjava;

import io.reactivex.Observable;

/**
 * 连接多个被观察者事件
 */
public class ConcatSample {

    public static void main(String[] args) {

        Observable.concat(Observable.just(1,2,3),Observable.just(4,5,6))
                .subscribe(event-> System.out.println("whatIs event : " + event));
    }

}

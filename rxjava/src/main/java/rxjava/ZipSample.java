package rxjava;

import io.reactivex.Observable;

/**
 * 合并多个被观察者事件
 */
public class ZipSample {

    public static void main(String[] args) {

        Observable.zip(Observable.just("A","B","C","D","E"),Observable.just(1,2,3,4,5,6),
                (str,num)-> str +" "+ num)
                .subscribe(event-> System.out.println("whatIs event : " + event ) );

    }

}

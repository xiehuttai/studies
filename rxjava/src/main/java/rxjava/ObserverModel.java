package rxjava;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * rxjava 基于事件流，实现异步的库
 * 类比 顾客（被观察对象）、点餐（事件）、服务员通知（订阅）、厨房（观察对象）
 */
public class ObserverModel {

    public static void main(String[] args) {


        /**
         * 1.被观察对象
         */
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            /**
             * 事件
             */
            observableEmitter.onNext(1);
            observableEmitter.onNext(2);
            observableEmitter.onNext(3);
            observableEmitter.onComplete();
        });

        /**
         * 被观察对象
         */
        Observable<String> observableJust = Observable.just("A", "B", "C");


        /**
         * 2.观察者：采用Observer 接口
         */
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("value : " +value );
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                System.out.println("complete.");
            }
        };

        /**
         * 3.订阅
         */
        observable.subscribe(observer);

    }

}
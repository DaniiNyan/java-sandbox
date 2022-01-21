package com.daniinyan.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableAndObservers {
    public static void main(String[] args) {
        Observable<String> interestingStrings = Observable.just("I am interesting", "Subscribers will love me", "I hope Subscribers like me");

        Observer<String> testing = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("on Subscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("on Next");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("on Error");
            }

            @Override
            public void onComplete() {
                System.out.println("on Complete");
            }
        };

        interestingStrings.safeSubscribe(testing);
    }
}

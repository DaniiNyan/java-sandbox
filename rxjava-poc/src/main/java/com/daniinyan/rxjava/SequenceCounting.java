package com.daniinyan.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class SequenceCounting {

    public static void main(String[] args) {
        Observable.range(0,10).subscribe(System.out::println);
    }
}

package com.daniinyan.rxjava.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlowableExample {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Erik", 20),
                new Person("Roberta", 19),
                new Person("Janna", 14)
        );

        Flowable<String> reactiveTest = Flowable.fromIterable(people)
                .observeOn(Schedulers.computation())
                .flatMap(Flowable::fromArray)
                .filter(person -> person.age >= 18)
                .map(Person::getName)
                .subscribeOn(Schedulers.io())
                .delay(3L, TimeUnit.SECONDS);

        System.out.println("Beginning...");

        reactiveTest.subscribe(reactivePerson ->
                System.out.println("Person: " + reactivePerson));
    }
}

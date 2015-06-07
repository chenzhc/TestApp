package com.test.app.fx;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;


/**
 * Created by zc on 15-6-7.
 */
public class ChangeAndInvalidationTest {

    public static void main(String[] args){
        IntegerProperty counter = new SimpleIntegerProperty(100);

        counter.addListener(ChangeAndInvalidationTest::invalidated);

        counter.addListener(ChangeAndInvalidationTest::changed);

        System.out.println("Before changing the counter value -1");
        counter.set(101);
        System.out.println("After changing the counter value -1");

        System.out.println("Before changing the counter value -2");
        counter.set(102);
        System.out.println("After changing the counter value -2");


    }

    public static void invalidated(Observable prop){
        System.out.println("Counter is invalid.");
    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue,
                               Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("old = " + oldValue
                + ", new = " + newValue);
    }
}

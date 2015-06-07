package com.test.app.fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

/**
 * Created by zc on 15-6-7.
 */
public class WeakListener {

    public static IntegerProperty counter = new SimpleIntegerProperty(100);
    public static WeakChangeListener<Number> weakListener;
    public static ChangeListener<Number> changeListener;

    public static void main(String[] args){
        addWeakListener();

        counter.set(300);

        System.gc();
        System.out.println("Garbage collected: "
                + weakListener.wasGarbageCollected());

        counter.set(400);

        changeListener = null;

        System.gc();

        System.out.println("Garbage collected: "
                + weakListener.wasGarbageCollected());

        counter.set(500);
    }

    public static void addWeakListener(){
        changeListener = WeakListener::changed;

        weakListener = new WeakChangeListener<>(changeListener);

        counter.addListener(weakListener);

        counter.set(200);
    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue,
                               Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("old = " + oldValue
                + ", new = " + newValue);
    }
}

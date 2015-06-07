package com.test.app.fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by zc on 15-6-7.
 */
public class StrongListener {
    public static IntegerProperty counter = new SimpleIntegerProperty(100);

    public static void addStrongListener(){
        ChangeListener<Number> listener = StrongListener::changed;
        counter.addListener(listener);

        counter.set(200);
    }

    public static void changed(ObservableValue<? extends Number> prop,
                               Number oldValue,
                               Number newValue) {
        System.out.println("Counter changed: old = "+ oldValue
                +", new = " + newValue);
    }

    public static void main(String[] args){
        addStrongListener();

        counter.set(300);
    }
}

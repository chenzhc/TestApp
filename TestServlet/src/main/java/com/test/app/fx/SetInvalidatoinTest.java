package com.test.app.fx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

/**
 * Created by zc on 15-6-8.
 */
public class SetInvalidatoinTest {

    public static void main(String[] args){
        ObservableSet<String> set =
                FXCollections.observableSet("one","two");

        set.addListener(SetInvalidatoinTest::invalidated);

        System.out.println("Before adding three.");
        set.add("three");
        System.out.println("After adding three.");

        System.out.println("\nBefore adding four.");
        set.add("four");
        System.out.println("After adding four.");

        System.out.println("\nBefore adding four.");
        set.add("four");
        System.out.println("After adding four.");
    }

    public static void invalidated(Observable set){
        System.out.println("Set is invalid.");
    }
}

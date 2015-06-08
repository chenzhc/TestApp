package com.test.app.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zc on 15-6-8.
 */
public class ObservableSetTest {
    public static void main(String[] args){
        ObservableSet<String> s1 = FXCollections.observableSet("One","two","three");
        System.out.println("s1: " + s1);

        Set<String> s2 = new HashSet<String>();
        s2.add("one");
        s2.add("two");
        System.out.println("s2: " + s2);

        ObservableSet<String> s3 = FXCollections.observableSet(s2);
        s3.add("three");
        System.out.println("s3: " + s3);

    }
}

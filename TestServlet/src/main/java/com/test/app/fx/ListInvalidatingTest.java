package com.test.app.fx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by zc on 15-6-7.
 */
public class ListInvalidatingTest {

    public static void invalidated(Observable list){
        System.out.println("List is invalid.");
    }

    public static void main(String[] args){
        ObservableList<String> list =
                FXCollections.observableArrayList("one","two");

        list.addListener(ListInvalidatingTest::invalidated);

        System.out.println("Before adding three.");
        list.add("three");
        System.out.println("After adding three.");

        System.out.println("Before adding four and five.");
        list.addAll("four","five");
        System.out.println("After adding four and five");

        System.out.println("Before replacing one with one");
        list.set(0,"one");
        System.out.println("After replacing one with one");
    }
}

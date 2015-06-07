package com.test.app.fx;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Created by zc on 15-6-7.
 */
public class SimpleListChangeTest {
    public static void onChanged(ListChangeListener.Change<? extends String> change){
        System.out.println("List has changed");
    }

    public static void main(String[] args){
        ObservableList<String> list =
                FXCollections.observableArrayList();

        list.addListener(SimpleListChangeTest::onChanged);

        list.add("one");
        list.add("two");
        FXCollections.sort(list);
        list.clear();
    }
}

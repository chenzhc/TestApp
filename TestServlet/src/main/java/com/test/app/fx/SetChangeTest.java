package com.test.app.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zc on 15-6-8.
 */
public class SetChangeTest {

    public static void main(String[] args){
        ObservableSet<String> set =
                FXCollections.observableSet("one","two");

        set.addListener(SetChangeTest::onChanged);

        set.add("three");

        set.add("one");

        Set<String> s = new HashSet<>();
        s.add("four");
        s.add("five");

        set.addAll(s);

        set.remove("one");
        set.clear();

    }

    public static void onChanged(SetChangeListener.Change<? extends String> change){
        if(change.wasAdded()){
            System.out.print("Added: " + change.getElementAdded());
        } else if(change.wasRemoved()){
            System.out.print("Removed: " + change.getElementRemoved());
        }

        System.out.println(", Set after the change: " + change.getSet());
    }
}

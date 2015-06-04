package com.test.app.fx.hello;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-4.
 */
public class FXLifeCycleApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("start() :" + name);

        Scene scene = new Scene(new Group(),200,200);
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }

    public FXLifeCycleApp(){
        String name = Thread.currentThread().getName();
        System.out.println("FXLifeCycleApp() :"+name);
    }

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("init() :" + name);
    }
}

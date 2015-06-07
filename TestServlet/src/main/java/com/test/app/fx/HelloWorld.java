package com.test.app.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-7.
 */
public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        Group root = new Group();

        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello world");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello world");
            }
        });

        root.getChildren().add(btn);

        Scene scene = new Scene(root,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

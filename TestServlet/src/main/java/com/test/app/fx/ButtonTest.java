package com.test.app.fx;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.text.html.Option;

/**
 * Created by zc on 15-6-8.
 */
public class ButtonTest extends Application{

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Stage with a Button in Screen");
        Group root = new Group(new Button("Hello"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
//        primaryStage.setWidth(400);
//        primaryStage.setHeight(100);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        double x = bounds.getMinX() + (bounds.getWidth()-primaryStage.getWidth())/2.0;
        double y = bounds.getMinY() + (bounds.getHeight()-primaryStage.getHeight())/2.0;
        primaryStage.setX(x);
        primaryStage.setY(y);

        primaryStage.show();
    }
}

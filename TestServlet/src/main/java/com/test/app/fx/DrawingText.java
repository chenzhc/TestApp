package com.test.app.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by zc on 15-6-7.
 */
public class DrawingText extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 2 Drawing Text");
        Group root = new Group();
        Scene scene = new Scene(root,400,650, Color.WHITE);
        Random random = new Random(System.currentTimeMillis());
        for(int i=0; i<100; i++){
            int x = random.nextInt((int)scene.getWidth());
            int y = random.nextInt((int)scene.getHeight());
            int red = random.nextInt(255);
            int green = random.nextInt(255);
            int blue = random.nextInt(255);
            Text text = new Text(x, y, "JavaFX 8");

            int rot = random.nextInt(360);
            text.setFill(Color.rgb(red,green,blue,.99));
            text.setRotate(rot);
            root.getChildren().add(text);
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

package com.test.app.fx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-7.
 */
public class CenteredCircle extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle c = new Circle();
        Group root = new Group(c);
        Scene scene = new Scene(root,400,500);

        c.centerXProperty().bind(scene.widthProperty().divide(2));
        c.centerYProperty().bind(scene.heightProperty().divide(2));
        c.radiusProperty().bind(Bindings.min(scene.widthProperty(),
                scene.heightProperty()).divide(2));

        primaryStage.setTitle("Binding in JavaFX");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

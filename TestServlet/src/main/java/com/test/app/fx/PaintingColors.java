package com.test.app.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-7.
 */
public class PaintingColors extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 2 Painting Colors");
        Group root = new Group();
        Scene scene = new Scene(root,350,300, Color.WHITE);

        Ellipse ellipse = new Ellipse(100,
                50+70/2,
                50,
                70/2);

        RadialGradient gradient1 = new RadialGradient(
                0,
                .1,
                80,
                45,
                120,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0,Color.RED),
                new Stop(1,Color.BLACK)
        );

        ellipse.setFill(gradient1);
        root.getChildren().add(ellipse);
        double ellipseHeight = ellipse.getBoundsInParent().getHeight();

        Line blackLine = new Line();
        blackLine.setStartX(170);
        blackLine.setStartY(30);
        blackLine.setEndX(20);
        blackLine.setEndY(30);
        blackLine.setFill(Color.BLACK);
        blackLine.setStrokeWidth(10.0f);
        blackLine.setTranslateY(ellipseHeight+10);
        root.getChildren().add(blackLine);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(100);
        rectangle.setHeight(70);
        rectangle.setTranslateY(ellipseHeight+10);

        LinearGradient linearGradient = new LinearGradient(
                0,
                0,
                0,
                1,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.1f,Color.rgb(255,200,0,.784)),
                new Stop(1.0f,Color.rgb(0,0,0,.784))
        );
        rectangle.setFill(linearGradient);
        root.getChildren().add(rectangle);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

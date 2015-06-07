package com.test.app.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-7.
 */
public class DrawingShape extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 2 Drawing Shapes");
        Group root = new Group();
        Scene scene = new Scene(root,306,550, Color.GREEN);

        CubicCurve cubicCurve = new CubicCurve(
                50,
                75,
                80,
                -25,
                110,
                175,
                140,
                75
        );
        cubicCurve.setStrokeType(StrokeType.CENTERED);
        cubicCurve.setStroke(Color.BLACK);
        cubicCurve.setStrokeWidth(3);
        cubicCurve.setFill(Color.WHITE);
        root.getChildren().add(cubicCurve);

        Path path = new Path();
        path.setStrokeWidth(3);

        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);

        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);

        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);

        LineTo lineTo3 = new LineTo();
        lineTo3.setY(150);
        lineTo3.setX(150);

        path.getElements().addAll(moveTo,quadCurveTo,lineTo1,lineTo2,lineTo3);

        path.setTranslateY(30);

        root.getChildren().add(path);

        QuadCurve quad = new QuadCurve(
                50,50,125,150,150,50
        );
        quad.setTranslateY(path.getBoundsInParent().getMaxY());
        quad.setStrokeWidth(3);
        quad.setStroke(Color.BLACK);
        quad.setFill(Color.WHITE);
        root.getChildren().add(quad);

        Ellipse bigCircle = new Ellipse(
                100,
                100,
                50,
                75/2
        );
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);

        Ellipse smallCircle = new Ellipse(
                100,
                100,
                35/2,
                25/2
        );
        Shape donut = Path.subtract(bigCircle,smallCircle);
        donut.setStrokeWidth(1.8);
        donut.setStroke(Color.BLACK);
        donut.setFill(Color.rgb(255,200,0));

        DropShadow dropShadow = new DropShadow(
                5,
                2.0f,
                2.0f,
                Color.rgb(50,50,50,.588)
        );
        donut.setEffect(dropShadow);
        donut.setTranslateY(quad.getBoundsInParent().getMinY()+30);
        root.getChildren().add(donut);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

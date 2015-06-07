package com.test.app.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by zc on 15-6-7.
 */
public class DrawingLines extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 2 Drawing Lines");

        Group root = new Group();
        Scene scene = new Scene(root,300,150, Color.GRAY);

        Line readLine = new Line(10,10,200,10);
        readLine.setStroke(Color.RED);
        readLine.setStrokeWidth(10);
        readLine.setStrokeLineCap(StrokeLineCap.BUTT);

        readLine.getStrokeDashArray().addAll(10d,5d,15d,5d,20d);
        readLine.setStrokeDashOffset(0);

        root.getChildren().add(readLine);

        Line whiteLine = new Line(10,30,200,30);
        whiteLine.setStroke(Color.WHITE);
        whiteLine.setStrokeWidth(10);
        whiteLine.setStrokeLineCap(StrokeLineCap.ROUND);
        root.getChildren().addAll(whiteLine);

        Line blueLine = new Line(10,50,200,50);
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(10);
        root.getChildren().addAll(blueLine);

        Slider slider = new Slider(0,100,0);
        slider.setLayoutX(10);
        slider.setLayoutY(95);

        readLine.strokeDashOffsetProperty().bind(slider.valueProperty());
        root.getChildren().addAll(slider);

        Text offsetText = new Text("Stroke Dash offset: 0.0");
        offsetText.setX(10);
        offsetText.setY(80);
        offsetText.setStroke(Color.WHITE);

        slider.valueProperty()
                .addListener((ov,curVal,newVal) ->
                        offsetText.setText("Stroke Dash Offset: " + slider.getValue()));
        root.getChildren().addAll(offsetText);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

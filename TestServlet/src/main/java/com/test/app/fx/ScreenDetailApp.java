package com.test.app.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-8.
 */
public class ScreenDetailApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Screen> screens = Screen.getScreens();
        System.out.println("Screens Count: " + screens.size());

        for(Screen screen: screens){
            print(screen);
        }

        Platform.exit();
    }

    public void print(Screen s){
        System.out.println("DPI: " + s.getDpi());

        System.out.println("Screen Bounds: ");
        Rectangle2D bounds = s.getBounds();
        print(bounds);

        System.out.print("Screen Visual Bounds: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.println("---------------------");

    }

    public void print(Rectangle2D r){
        System.out.format("minX=%.2f, minY=%.2f,width=%.2f,height=%.2f\n",
                r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}

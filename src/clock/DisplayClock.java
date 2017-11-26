/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DisplayClock extends Application{
    @Override
    public void start(Stage stage){
        Clock clock = new Clock();
        StackPane sp = new StackPane();
        sp.getChildren().add(clock);
        Scene scene = new Scene(sp, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String []args){
        launch(args);
    }
}
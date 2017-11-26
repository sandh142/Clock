
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Clock extends Pane {
    private int hour;
    private int minute;
    private int second;
    final private double w;
    final private double h;

    public Clock(){
        w = 550;
        h = 550;
        Timeline _timer = new Timeline(new KeyFrame(Duration.millis(1000), (e) -> {
            setCurrentTime();
        }));
_timer.setCycleCount(Timeline.INDEFINITE);
_timer.play();
        
    }
    public void setCurrentTime(){
        GregorianCalendar calendar = new GregorianCalendar();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        paintClock();
    }
    private void paintClock(){
        double clockRadius = 100;
        double centerX = w / 2;
        double centerY = h / 2;
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.BEIGE);
        circle.setStroke(Color.BLACK);
        Text t12 = new Text(centerX - 5, centerY - clockRadius + 15, "12");
        Text t3 = new Text(centerX + clockRadius - 15, centerY + 5, "3");
        Text t6 = new Text(centerX - 5, centerY + clockRadius - 5, "6");
        Text t9 = new Text(centerX - clockRadius + 5, centerY + 5, "9");
        double secondHandLength = clockRadius * 0.8;
        double secondX = centerX + 
                secondHandLength * Math.sin(second * (2 * Math.PI)/60);
        double secondY = centerY - 
                secondHandLength * Math.cos(second * (2 * Math.PI)/60);
        Line secondHand = new Line(centerX, centerY, secondX, secondY);
        double minuteHandLength = clockRadius * 0.6;
        double minuteX = centerX + 
                minuteHandLength * 
                Math.sin((minute + second/60.0)* (2 * Math.PI)/60);
        double minuteY = centerY - 
                minuteHandLength * 
                Math.cos((minute + second/60.0) * (2 * Math.PI)/60);
        Line minuteHand = new Line(centerX, centerY, minuteX, minuteY);
        minuteHand.setStrokeWidth(3);
        double hourHandLength = clockRadius * 0.45;
        double hourX = centerX + 
                hourHandLength * 
                Math.sin((hour%12 + minute/60.0 + second/3600.0)* (2 * Math.PI)/12);
        double hourY = centerY - 
                hourHandLength * 
                Math.cos((hour%12 + minute/60.0 + second/3600.0) * (2 * Math.PI)/12);
        Line hourHand = new Line(centerX, centerY, hourX, hourY);
        hourHand.setStrokeWidth(5);
        
        secondHand.setStroke(Color.RED);
        
        
        
        getChildren().addAll(circle, t12, t3, t6, t9,
                secondHand, minuteHand, hourHand);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
/**
 *
 * @author euclasio
 */
public class resolution {
    private static double resX;
    private static double resY;
    
    public static void getResolution(){
        Rectangle2D bounds = Screen.getScreens().get(0).getBounds();
        resX = bounds.getMaxX();
        resY = bounds.getMaxY();
    }

    public static double getResX() {
        return resX;
    }

    public static double getResY() {
        return resY;
    }
}

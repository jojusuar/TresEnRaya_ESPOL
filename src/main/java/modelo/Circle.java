/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author euclasio
 */
public class Circle extends Symbol implements Serializable{

    public Circle() {
        super("main/resources/assets/circle.png");
    }  
    
    @Override
    public String toString() {
        return " O ";
    }
}

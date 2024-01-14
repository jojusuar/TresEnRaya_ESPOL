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
public class Cross extends Symbol implements Serializable {
    
    public Cross() {
        super("main/resources/assets/cross.png");
    }

    @Override
    public String toString() {
        return "X";
    }
    
}

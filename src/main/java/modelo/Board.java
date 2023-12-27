/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author euclasio
 */
public class Board {
    private Symbol[][] cells;
    private int utility;
    
    public Board(){
        cells = new Symbol[3][3];
    }

    public Symbol[][] getCells() {
        return cells;
    }
    
    public void utilityFunction(){
        //TODO
    }
}

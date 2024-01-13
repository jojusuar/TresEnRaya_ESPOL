/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author euclasio
 */
public class Board {

    private Symbol[][] cells;
    private Comparator<Symbol> cmp;
    private int turnsLeft;
    private int utility;

    public Board() {
        cells = new Symbol[3][3];
        cmp = Symbol.comparator();
        turnsLeft = 9;
    }

    public Symbol[][] getCells() {
        return cells;
    }

    public int checkBoard() {
        Symbol s00 = cells[0][0];
        Symbol s10 = cells[1][0];
        Symbol s20 = cells[2][0];
        Symbol s01 = cells[0][1];
        Symbol s11 = cells[1][1];
        Symbol s21 = cells[2][1];
        Symbol s02 = cells[0][2];
        Symbol s12 = cells[1][2];
        Symbol s22 = cells[2][2];
        if (cmp.compare(s00, s10) != 0 && cmp.compare(s10, s20) != 0 && cmp.compare(s00, s10) == cmp.compare(s10, s20)) {
            return cmp.compare(s00, s10);
        }
        if (cmp.compare(s01, s11) != 0 && cmp.compare(s11, s21) != 0 && cmp.compare(s01, s11) == cmp.compare(s11, s21)) {
            return cmp.compare(s01, s11);
        }
        if (cmp.compare(s02, s12) != 0 && cmp.compare(s12, s22) != 0 && cmp.compare(s02, s12) == cmp.compare(s12, s22)) {
            return cmp.compare(s02, s12);
        }
        if (cmp.compare(s00, s01) != 0 && cmp.compare(s01, s02) != 0 && cmp.compare(s00, s01) == cmp.compare(s01, s02)) {
            return cmp.compare(s00, s01);
        }
        if (cmp.compare(s10, s11) != 0 && cmp.compare(s11, s12) != 0 && cmp.compare(s10, s11) == cmp.compare(s11, s12)) {
            return cmp.compare(s10, s11);
        }
        if (cmp.compare(s20, s21) != 0 && cmp.compare(s21, s22) != 0 && cmp.compare(s20, s21) == cmp.compare(s21, s22)) {
            return cmp.compare(s20, s21);
        }
        if (cmp.compare(s00, s11) != 0 && cmp.compare(s11, s22) != 0 && cmp.compare(s00, s11) == cmp.compare(s11, s22)) {
            return cmp.compare(s00, s11);
        }
        if (cmp.compare(s20, s11) != 0 && cmp.compare(s11, s02) != 0 && cmp.compare(s20, s11) == cmp.compare(s11, s02)) {
            return cmp.compare(s20, s11);
        }
        return 0;
    }
    
    public void nextTurn(){
        turnsLeft--;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void utilityFunction() {
        //TODO
    }

}

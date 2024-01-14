/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author euclasio
 */
public class GameMaster implements Serializable{

    private static boolean crossTurn;

    public static int checkBoard(Board board) {
        Comparator<Symbol> cmp = board.getCmp();
        Symbol[][] cells = board.getCells();
        Symbol s00 = cells[0][0];
        Symbol s10 = cells[1][0];
        Symbol s20 = cells[2][0];
        Symbol s01 = cells[0][1];
        Symbol s11 = cells[1][1];
        Symbol s21 = cells[2][1];
        Symbol s02 = cells[0][2];
        Symbol s12 = cells[1][2];
        Symbol s22 = cells[2][2];
        if (cmp.compare(s00, s10) != -1 && cmp.compare(s10, s20) != -1 && cmp.compare(s00, s10) == cmp.compare(s10, s20)) {
            return cmp.compare(s00, s10);
        }
        if (cmp.compare(s01, s11) != -1 && cmp.compare(s11, s21) != -1 && cmp.compare(s01, s11) == cmp.compare(s11, s21)) {
            return cmp.compare(s01, s11);
        }
        if (cmp.compare(s02, s12) != -1 && cmp.compare(s12, s22) != -1 && cmp.compare(s02, s12) == cmp.compare(s12, s22)) {
            return cmp.compare(s02, s12);
        }
        if (cmp.compare(s00, s01) != -1 && cmp.compare(s01, s02) != -1 && cmp.compare(s00, s01) == cmp.compare(s01, s02)) {
            return cmp.compare(s00, s01);
        }
        if (cmp.compare(s10, s11) != -1 && cmp.compare(s11, s12) != -1 && cmp.compare(s10, s11) == cmp.compare(s11, s12)) {
            return cmp.compare(s10, s11);
        }
        if (cmp.compare(s20, s21) != -1 && cmp.compare(s21, s22) != -1 && cmp.compare(s20, s21) == cmp.compare(s21, s22)) {
            return cmp.compare(s20, s21);
        }
        if (cmp.compare(s00, s11) != -1 && cmp.compare(s11, s22) != -1 && cmp.compare(s00, s11) == cmp.compare(s11, s22)) {
            return cmp.compare(s00, s11);
        }
        if (cmp.compare(s20, s11) != -1 && cmp.compare(s11, s02) != -1 && cmp.compare(s20, s11) == cmp.compare(s11, s02)) {
            return cmp.compare(s20, s11);
        }
        return -1;
    }

    public static boolean isCrossTurn() {
        return crossTurn;
    }

    public static void setCrossTurn(boolean b) {
        crossTurn = b;
    }
}

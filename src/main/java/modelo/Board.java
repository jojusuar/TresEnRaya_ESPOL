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
    private String description;

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public Comparator<Symbol> getCmp() {
        return cmp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Board() {
        cells = new Symbol[3][3];
        cmp = Symbol.comparator();
        turnsLeft = 9;
    }

    public Symbol[][] getCells() {
        return cells;
    }

    public void nextTurn() {
        turnsLeft--;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void utilityFunction() {
        //TODO
    }

    public Board getCopy() {
        Board copy = new Board();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                copy.cells[i][j] = this.cells[i][j];
            }
        }
        copy.turnsLeft = this.turnsLeft;
        return copy;
    }

    public static Comparator<Board> comparator() {
        Comparator<Symbol> cmp = Symbol.comparator();
        return (Board b1, Board b2) -> {
            for (int i = 0; i < b1.cells.length; i++) {
                for (int j = 0; j < b1.cells.length; j++) {
                    if (cmp.compare(b1.cells[i][j], b2.cells[i][j]) != 0) {
                        return -1;
                    }
                }
            }
            return 0;
        };
    }

    public String toString() {
        String representation = "" + cells[0][0] + "|" + cells[1][0] + "|" + cells[2][0] + "\n" + "---------------" + "\n" + cells[0][1] + "|" + cells[1][1] + "|" + cells[2][1] + "\n" + "---------------" + "\n" + cells[0][2] + "|" + cells[1][2] + "|" + cells[2][2] + "\n";
        return representation;
    }
}

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
    private int crossUtility;
    private int circleUtility;
    private String description;

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

    public int getCrossUtility() {
        return crossUtility;
    }

    public void setCrossUtility(int crossUtility) {
        this.crossUtility = crossUtility;
    }

    public int getCircleUtility() {
        return circleUtility;
    }

    public void setCircleUtility(int circleUtility) {
        this.circleUtility = circleUtility;
    }
    
    public <E> int utilityFunction(Class<E> human){
        //ingresa la clase con la que juega el humano: Circle.class o Cross.class
        //se lo puede interpretar como el diferencial de ventaja entre jugadores
        Class computer = Circle.class;
        if(computer.equals(human)){
            computer = Cross.class;
        }
        int computerP = pxFunction(human);
        int humanP = pxFunction(computer);
        return computerP - humanP;
    }

    public <T> int pxFunction(Class<T> adversary) {
        //basicamente retorna el numero de posibilidades de ganar en el estado del tablero actual
        int utility = 0;
        Symbol s00 = cells[0][0];
        Symbol s10 = cells[1][0];
        Symbol s20 = cells[2][0];
        Symbol s01 = cells[0][1];
        Symbol s11 = cells[1][1];
        Symbol s21 = cells[2][1];
        Symbol s02 = cells[0][2];
        Symbol s12 = cells[1][2];
        Symbol s22 = cells[2][2];
        if (!(adversary.isInstance(s00)) && !(adversary.isInstance(s10)) && !(adversary.isInstance(s20))) {
            utility++;
        }
        if (!(adversary.isInstance(s01)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s21))) {
            utility++;
        }
        if (!(adversary.isInstance(s02)) && !(adversary.isInstance(s12)) && !(adversary.isInstance(s22))) {
            utility++;
        }
        if (!(adversary.isInstance(s00)) && !(adversary.isInstance(s01)) && !(adversary.isInstance(s02))) {
            utility++;
        }
        if (!(adversary.isInstance(s10)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s12))) {
            utility++;
        }
        if (!(adversary.isInstance(s20)) && !(adversary.isInstance(s21)) && !(adversary.isInstance(s22))) {
            utility++;
        }
        if (!(adversary.isInstance(s00)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s22))) {
            utility++;
        }
        if (!(adversary.isInstance(s20)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s02))) {
            utility++;
        }
        return utility;
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

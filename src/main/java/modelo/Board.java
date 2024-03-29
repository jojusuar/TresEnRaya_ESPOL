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
public class Board implements Serializable {

    private Symbol[][] cells;
    private Comparator<Symbol> cmp;
    private int turnsLeft;
    private int utility;
    private int choiceX;
    private int choiceY;
    private String description;
    private boolean crossTurnWhenSaved;

    public boolean isCrossTurnWhenSaved() {
        return crossTurnWhenSaved;
    }

    public void setCrossTurnWhenSaved(boolean crossTurnWhenSaved) {
        this.crossTurnWhenSaved = crossTurnWhenSaved;
    }

    public int getChoiceX() {
        return choiceX;
    }

    public void setChoiceX(int choiceX) {
        this.choiceX = choiceX;
    }

    public int getChoiceY() {
        return choiceY;
    }

    public void setChoiceY(int choiceY) {
        this.choiceY = choiceY;
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

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public <E, T> int utilityFunction(Class<E> human, Class<T> computer, boolean hard) {
        //ingresa la clase con la que juega el humano: Circle.class o Cross.class
        //se lo puede interpretar como el diferencial de ventaja entre jugadores
        int computerP = pxFunction(human, false, hard);
        int humanP = pxFunction(computer, true, hard);
        int diff = computerP - humanP;
        //System.out.println(this+"  utilidad computadora= "+computerP+"  utilidad humano= "+humanP+"  diferencia= "+diff);
        return diff;
    }

    public <T> int pxFunction(Class<T> adversary, boolean bias, boolean hard) {
        int utility = 0;
        int safeguard = -100; //si una jugada implica la derrota, la descarta automaticamente
        if (bias) {
            safeguard = -200; //si la jugada implica la victoria, le da prioridad maxima
        }
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
        } else if (adversary.isInstance(s00) && adversary.isInstance(s10) && adversary.isInstance(s20)) {
            return safeguard;
        }
        if (!(adversary.isInstance(s01)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s21))) {
            utility++;
            if (hard & bias) { //el modo dificil resta la utilidad del adversario en la cruz central para favorecer a las esquinas, pues son mas peligrosas
                utility--;
            }
        } else if ((adversary.isInstance(s01)) && (adversary.isInstance(s11)) && adversary.isInstance(s21)) {
            return safeguard;
        }
        if (!(adversary.isInstance(s02)) && !(adversary.isInstance(s12)) && !(adversary.isInstance(s22))) {
            utility++;
        } else if (adversary.isInstance(s02) && adversary.isInstance(s12) && adversary.isInstance(s22)) {
            return safeguard;
        }
        if (!(adversary.isInstance(s00)) && !(adversary.isInstance(s01)) && !(adversary.isInstance(s02))) {
            utility++;
        } else if ((adversary.isInstance(s00)) && (adversary.isInstance(s01)) && (adversary.isInstance(s02))) {
            return safeguard;
        }
        if (!(adversary.isInstance(s10)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s12))) {
            utility++;
            if (hard & bias) {
                utility--;
            }
        } else if ((adversary.isInstance(s10)) && (adversary.isInstance(s11)) && (adversary.isInstance(s12))) {
            return safeguard;
        }
        if (!(adversary.isInstance(s20)) && !(adversary.isInstance(s21)) && !(adversary.isInstance(s22))) {
            utility++;
        } else if ((adversary.isInstance(s20)) && (adversary.isInstance(s21)) && (adversary.isInstance(s22))) {
            return safeguard;
        }
        if (!(adversary.isInstance(s00)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s22))) {
            utility++;
            if (hard & bias) {
                utility--;
            }
        } else if ((adversary.isInstance(s00)) && (adversary.isInstance(s11)) && (adversary.isInstance(s22))) {
            return safeguard;
        }
        if (!(adversary.isInstance(s20)) && !(adversary.isInstance(s11)) && !(adversary.isInstance(s02))) {
            utility++;
            if (hard & bias) {
                utility--;
            }
        } else if ((adversary.isInstance(s20)) && (adversary.isInstance(s11)) && (adversary.isInstance(s02))) {
            return safeguard;
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
        copy.crossTurnWhenSaved = this.crossTurnWhenSaved;
        copy.description = this.description;
        return copy;
    }

    public static Comparator<Board> comparator() {
        return new BoardComparator();
    }

    public String toString() {
        Board toPrint = this.getCopy();
        toPrint.description = this.description;
        for (int i = 0; i < toPrint.cells.length; i++) {
            for (int j = 0; j < toPrint.cells.length; j++) {
                if (toPrint.cells[i][j] == null) {
                    toPrint.cells[i][j] = new Blank();
                }
            }
        }
        String representation = "" + toPrint.cells[0][0] + "|" + toPrint.cells[1][0] + "|" + toPrint.cells[2][0] + "\n" + "---------------" + "\n" + toPrint.cells[0][1] + "|" + toPrint.cells[1][1] + "|" + toPrint.cells[2][1] + "      " +toPrint.description +"\n" + "---------------" + "\n" + toPrint.cells[0][2] + "|" + toPrint.cells[1][2] + "|" + toPrint.cells[2][2] + "\n"
                + "**************************************";
        return representation;
    }
    
    public String toGrid() {
        
        Board toPrint = this.getCopy();
        toPrint.utility = this.utility;
        for (int i = 0; i < toPrint.cells.length; i++) {
            for (int j = 0; j < toPrint.cells.length; j++) {
                if (toPrint.cells[i][j] == null) {
                    toPrint.cells[i][j] = new Blank();
                }
            }
        }
        String representation = "" + toPrint.cells[0][0] + "|" + toPrint.cells[1][0] + "|" + toPrint.cells[2][0] + "\n" + "---------------" + "\n" + toPrint.cells[0][1] + "|" + toPrint.cells[1][1] + "|" + toPrint.cells[2][1] + "\n" + "---------------" + "\n" + toPrint.cells[0][2] + "|" + toPrint.cells[1][2] + "|" + toPrint.cells[2][2] + "\n"+ "utilidad = "+toPrint.utility;
        return representation;
    }
    
    
}

class BoardComparator implements Comparator<Board>, Serializable{

    @Override
    public int compare(Board b1, Board b2) {
        Comparator<Symbol> cmp = Symbol.comparator();

        for (int i = 0; i < b1.getCells().length; i++) {
            for (int j = 0; j < b1.getCells()[i].length; j++) {
                if (cmp.compare(b1.getCells()[i][j], b2.getCells()[i][j]) == -1) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

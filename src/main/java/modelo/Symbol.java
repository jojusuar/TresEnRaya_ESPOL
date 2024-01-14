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
public abstract class Symbol implements Serializable {

    protected String path;

    public Symbol(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Comparator<Symbol> comparator() {
        return new SymbolComparator();
    }
}

    class SymbolComparator implements Comparator<Symbol>, Serializable{
    @Override
    public int compare(Symbol s1, Symbol s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 instanceof Circle && s2 instanceof Circle) {
            return 1;
        } else if (s1 instanceof Cross && s2 instanceof Cross) {
            return 2;
        }
        return -1;
    }
}

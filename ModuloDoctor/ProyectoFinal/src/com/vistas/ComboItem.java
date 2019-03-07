
package com.vistas;

/**
*  Nombre de la clase: ComboItem
 * Fecha:11-08-2018
 * Versión: 1.0
 * CopyRight:ITCA-FEPADE
 * @author Fabio Mejia
 */
public class ComboItem {

    public ComboItem() {
    }

    private int value;
    private String label;

    public ComboItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}

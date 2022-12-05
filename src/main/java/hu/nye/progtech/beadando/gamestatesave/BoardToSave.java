package hu.nye.progtech.beadando.gamestatesave;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Tablabol ment.
 */
@XmlRootElement
public class BoardToSave {
    int[][] tabla;

    public BoardToSave(int[][] tabla) {
        this.tabla = tabla;
    }

    public BoardToSave() {
    }

    public int[][] getTabla() {
        return tabla;
    }

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }
}

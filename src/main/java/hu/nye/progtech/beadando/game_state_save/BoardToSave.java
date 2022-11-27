package hu.nye.progtech.beadando.game_state_save;

import jakarta.xml.bind.annotation.XmlRootElement;

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

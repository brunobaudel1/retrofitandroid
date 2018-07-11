
package com.example.brunobaudelsantana.vendaprodutos.modelo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("cells")
    @Expose
    private List<Cell> cells = null;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

}

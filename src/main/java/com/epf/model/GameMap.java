package com.epf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GameMap {
    @JsonProperty("id_map")
    private Long idMap;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public GameMap() {}

    public GameMap(Long idMap, int ligne, int colonne, String cheminImage) {
        this.idMap = idMap;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }
    // getters & setters...

    public Long getIdMap() { return idMap; }
    public void setIdMap(Long idMap) { this.idMap = idMap; }

    public int getLigne() { return ligne; }
    public void setLigne(int ligne) { this.ligne = ligne; }

    public int getColonne() { return colonne; }
    public void setColonne(int colonne) { this.colonne = colonne; }

    public String getCheminImage() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
}

    
 

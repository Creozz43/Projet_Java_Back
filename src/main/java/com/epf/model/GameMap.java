package com.epf.model;

import java.util.Objects;

public class GameMap {
    private Long id;
    private String terrainType;

    public GameMap() { }
    public GameMap(Long id, String terrainType) {
        this.id = id; this.terrainType = terrainType;
    }
    public Long getId()                   { return id; }
    public void setId(Long id)            { this.id = id; }
    public String getTerrainType()        { return terrainType; }
    public void setTerrainType(String terrainType) { this.terrainType = terrainType; }

    @Override public String toString() {
        return "GameMap{id="+id+", terrainType='"+terrainType+"'}";
    }
    @Override public boolean equals(Object o) {
        if(this==o) return true;
        if(!(o instanceof GameMap)) return false;
        GameMap m=(GameMap)o;
        return Objects.equals(id,m.id)&&Objects.equals(terrainType,m.terrainType);
    }
    @Override public int hashCode() {
        return Objects.hash(id,terrainType);
    }
}
package com.epf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Zombie {
    @JsonProperty("id_zombie")
    private Long idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    @JsonProperty("vitesse_de_deplacement")
    private double vitesseDeplacement;
    private String cheminImage;
    @JsonProperty("id_map")
    private Long idMap;        // peut être null

    public Zombie() {}

    public Zombie(Long idZombie, String nom, int pv, double aps, int da, double vitesse,
                  String cheminImage, Long idMap) {
        this.idZombie = idZombie; this.nom = nom; this.pointDeVie = pv;
        this.attaqueParSeconde = aps; this.degatAttaque = da;
        this.vitesseDeplacement = vitesse; this.cheminImage = cheminImage;
        this.idMap = idMap;
    }
 

    // getters & setters    
    public Long getIdZombie() { return idZombie; }
    public void setIdZombie(Long idZombie) { this.idZombie = idZombie; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getPointDeVie() { return pointDeVie; }
    public void setPointDeVie(int pointDeVie) { this.pointDeVie = pointDeVie; }
    public double getAttaqueParSeconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(double attaqueParSeconde) { this.attaqueParSeconde = attaqueParSeconde; }
    public int getDegatAttaque() { return degatAttaque; }
    public void setDegatAttaque(int degatAttaque) { this.degatAttaque = degatAttaque; }
    public double getVitesseDeplacement() { return vitesseDeplacement; }
    public void setVitesseDeplacement(double vitesseDeplacement) { this.vitesseDeplacement = vitesseDeplacement; }
    public String getCheminImage() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
    public Long getIdMap() { return idMap; }
    public void setIdMap(Long idMap) { this.idMap = idMap; }

}

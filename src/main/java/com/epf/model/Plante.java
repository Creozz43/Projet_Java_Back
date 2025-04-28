package com.epf.model;

import java.util.Objects;

public class Plante {
    private Long idPlante;
    private String nom;
    private Integer pointDeVie;
    private Double attaqueParSeconde;
    private Integer degatAttaque;
    private Integer cout;
    private Double soleilParSeconde;
    private String effet;
    private String cheminImage;

    public Plante() { }

    public Plante(Long idPlante,
                  String nom,
                  Integer pointDeVie,
                  Double attaqueParSeconde,
                  Integer degatAttaque,
                  Integer cout,
                  Double soleilParSeconde,
                  String effet,
                  String cheminImage) {
        this.idPlante = idPlante;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // --- Getters & Setters ---

    public Long getIdPlante() {
        return idPlante;
    }

    public void setIdPlante(Long idPlante) {
        this.idPlante = idPlante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(Integer pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public Double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public void setAttaqueParSeconde(Double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public Integer getDegatAttaque() {
        return degatAttaque;
    }

    public void setDegatAttaque(Integer degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public Double getSoleilParSeconde() {
        return soleilParSeconde;
    }

    public void setSoleilParSeconde(Double soleilParSeconde) {
        this.soleilParSeconde = soleilParSeconde;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "idPlante=" + idPlante +
                ", nom='" + nom + '\'' +
                ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde +
                ", degatAttaque=" + degatAttaque +
                ", cout=" + cout +
                ", soleilParSeconde=" + soleilParSeconde +
                ", effet='" + effet + '\'' +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plante)) return false;
        Plante p = (Plante) o;
        return Objects.equals(idPlante, p.idPlante) &&
               Objects.equals(nom, p.nom) &&
               Objects.equals(pointDeVie, p.pointDeVie) &&
               Objects.equals(attaqueParSeconde, p.attaqueParSeconde) &&
               Objects.equals(degatAttaque, p.degatAttaque) &&
               Objects.equals(cout, p.cout) &&
               Objects.equals(soleilParSeconde, p.soleilParSeconde) &&
               Objects.equals(effet, p.effet) &&
               Objects.equals(cheminImage, p.cheminImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlante, nom, pointDeVie, attaqueParSeconde,
                            degatAttaque, cout, soleilParSeconde, effet, cheminImage);
    }
}

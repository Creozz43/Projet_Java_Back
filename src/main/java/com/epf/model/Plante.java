package com.epf.model;

public class Plante {
    private Long id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private String effet;
    private String cheminImage;

    public Plante() {}

    public Plante(Long id, String nom, int pointDeVie, double attaqueParSeconde,
                  int degatAttaque, int cout, double soleilParSeconde,
                  String effet, String cheminImage) {
        this.id = id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPointDeVie() { return pointDeVie; }
    public void setPointDeVie(int pointDeVie) { this.pointDeVie = pointDeVie; }

    public double getAttaqueParSeconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(double atk) { this.attaqueParSeconde = atk; }

    public int getDegatAttaque() { return degatAttaque; }
    public void setDegatAttaque(int deg) { this.degatAttaque = deg; }

    public int getCout() { return cout; }
    public void setCout(int cout) { this.cout = cout; }

    public double getSoleilParSeconde() { return soleilParSeconde; }
    public void setSoleilParSeconde(double sp) { this.soleilParSeconde = sp; }

    public String getEffet() { return effet; }
    public void setEffet(String effet) { this.effet = effet; }

    public String getCheminImage() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
}

package com.example.listapp.classes;
public class Produit {
    private int id;
    private String nom;
    private int nbrIndegredients;
    private int photo;
    private String duree;
    private String detaisIngrediant;
    private String description;
    private String preparation;
    private static int cmp=0;


    public Produit(String nom, int nbrIndegredients, int photo, String duree, String detaisIngrediant, String description, String preparation) {
        this.id = ++cmp;
        this.nom = nom;
        this.nbrIndegredients = nbrIndegredients;
        this.photo = photo;
        this.duree = duree;
        this.detaisIngrediant = detaisIngrediant;
        this.description = description;
        this.preparation = preparation;
    }

    public Produit() {
        this.id = ++cmp;
        this.nom = "";
        this.nbrIndegredients = 0;
        this.photo = 0;
        this.duree = "";
        this.detaisIngrediant = "";
        this.description = "";
        this.preparation = "";
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbrIndegredients() {
        return nbrIndegredients;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDuree() {
        return duree;
    }

    public String getDetaisIngrediant() {
        return detaisIngrediant;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public static int getCmp() {
        return cmp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbrIndegredients(int nbrIndegredients) {
        this.nbrIndegredients = nbrIndegredients;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setDetaisIngrediant(String detaisIngrediant) {
        this.detaisIngrediant = detaisIngrediant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public static void setCmp(int cmp) {
        Produit.cmp = cmp;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrIndegredients=" + nbrIndegredients +
                ", photo=" + photo +
                ", duree=" + duree +
                ", detaisIngrediant='" + detaisIngrediant + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
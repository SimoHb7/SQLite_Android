package com.example.listapp.service;

import com.example.listapp.classes.Produit;
import com.example.listapp.dao.IDao;
import com.example.listapp.R;

import java.util.ArrayList;
import java.util.List;

import com.example.listapp.classes.Produit;
import com.example.listapp.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private List<Produit> produits;
    private static ProduitService instance;
    public ProduitService(){
        produits = new ArrayList<>();
    }
    public static ProduitService getInstance() {
        if(instance == null)
            instance =  new ProduitService();
        return instance;
    }
    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        Produit p = findById(o.getId());
        p.setNom(o.getNom());
        p.setNbrIndegredients(o.getNbrIndegredients());
        p.setPhoto(o.getPhoto());
        p.setDuree(o.getDuree());
        p.setDetaisIngrediant(o.getDetaisIngrediant());
        p.setDescription(o.getDescription());
        p.setPreparation(o.getPreparation());

        return true;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for(Produit p : produits){
            if(p.getId() == id)
                return p;
        }
        return null;

    }
}
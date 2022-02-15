/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion.entities;

/**
 *
 * @author islemferchichi
 */
public class GestiondeLivraison {
    private int IdCommande;
    private String NomLivreur;
    //private String TelClient;
    //private String adresse;
    private double FraisdeLivraison;

    public GestiondeLivraison() {
    }

    public GestiondeLivraison(int IdCommande,String NomLivreur, double FraisdeLivraison) {
        this.IdCommande = IdCommande;
        this.NomLivreur = NomLivreur;
        this.FraisdeLivraison = FraisdeLivraison;
    }

    public GestiondeLivraison(int IdCommande, double FraisdeLivraison) {
        this.IdCommande = IdCommande;
        this.FraisdeLivraison = FraisdeLivraison;
    }

    public int getIdCommande() {
        return IdCommande;
    }

    public void setIdCommande(int IdCommande) {
        this.IdCommande = IdCommande;
    }

    public String getNomLivreur( ) {
        return NomLivreur;
    }

    public void setNomlivreur(String NomLivreur ) {
        this.NomLivreur = NomLivreur;
    }

    public double getFraisdeLivraison() {
        return FraisdeLivraison;
    }

    public void setFraisdeLivraison(double FraisdeLivraison) {
        this.FraisdeLivraison = FraisdeLivraison;
    }

    @Override
    public String toString() {
        return "GestiondeLivraison{" + "IdCommande=" + IdCommande + ", NomLivreurr=" + NomLivreur + ", FraisdeLivraison=" + FraisdeLivraison + '}';
    }

       
}

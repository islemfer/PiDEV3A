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
    private int idCommande;
    private String nomlivreur;
    //private String TelClient;
    //private String adresse;
    private double FraisdeLivraison;

    public GestiondeLivraison() {
    }

    public GestiondeLivraison(int idCommande, String nomlivreur, double FraisdeLivraison) {
        this.idCommande = idCommande;
        this.nomlivreur = nomlivreur;
        this.FraisdeLivraison = FraisdeLivraison;
    }

    public GestiondeLivraison(String nomlivreur, double FraisdeLivraison) {
        this.nomlivreur = nomlivreur;
        this.FraisdeLivraison = FraisdeLivraison;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getNomlivreur() {
        return nomlivreur;
    }

    public void setNomlivreur(String nomlivreur) {
        this.nomlivreur = nomlivreur;
    }

    public double getFraisdeLivraison() {
        return FraisdeLivraison;
    }

    public void setFraisdeLivraison(double FraisdeLivraison) {
        this.FraisdeLivraison = FraisdeLivraison;
    }

    @Override
    public String toString() {
        return "GestiondeLivraison{" + "idCommande=" + idCommande + ", nomlivreur=" + nomlivreur + ", FraisdeLivraison=" + FraisdeLivraison + '}';
    }

       
}

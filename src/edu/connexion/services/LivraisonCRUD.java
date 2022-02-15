/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion.services;

import edu.connexion.entities.GestiondeLivraison;
import edu.connexion.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author islemferchichi
 */
public class LivraisonCRUD {

    //Connection cnx2;
   
        //cnx2 = MyConnection.getInstance().getCnx();
    
    public void addLivraison(GestiondeLivraison l) {
        try {
            String request = "INSERT INTO GestiondeLivraison(IdCommande,NomLivreur,FraisdeLivraison) VALUES(?,?,?) ";
            PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().prepareStatement(request);
             
        pst.setInt(1,l.getIdCommande());
         pst.setString(2,l.getNomLivreur());
     
        pst.setDouble(3,l.getFraisdeLivraison());
   
        pst.executeUpdate();
            System.out.println("la Livraison est ajouté! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void updateLivraison(GestiondeLivraison l) {
        try {
            String request = "UPDATE GestiondeLivraison Set NomLivreur = ?, FraisdeLivraison = ? where idCommande = ?  ";
          PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().prepareStatement(request);
            pst.setString(1, l.getNomLivreur());
            pst.setDouble(2, l.getFraisdeLivraison());
            pst.setInt(3,l.getIdCommande());
            //pst.setInt(3, l.getIdCommande());
            pst.executeUpdate();
           System.out.println("Livraison modifié! ");
  
      }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }}
    public void deleteLivraison(int x) {
        try {
            String request = "DELETE FROM GestiondeLivraison  where IdCommande = ?  ";
           PreparedStatement pst = (PreparedStatement) MyConnection.getInstance().getCnx().prepareStatement(request);
            pst.setInt(1, x);
            
            pst.executeUpdate();
           System.out.println("Livraison annulé! ");
  
      }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }}

  public List<GestiondeLivraison> DisplayLivraison() {
        List<GestiondeLivraison> myList = new ArrayList();
        try {
            String request = "Select * from GestiondeLivraison";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet res = st.executeQuery(request);

            while (res.next()) {
                GestiondeLivraison gl = new GestiondeLivraison();
                gl.setIdCommande(res.getInt(1));
                //gl.setIdLivreur(res.getInt(2));
                gl.setNomlivreur(res.getString(2));
                gl.setFraisdeLivraison(res.getDouble(3));

                myList.add(gl);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    
}






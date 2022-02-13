/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion.services;


import edu.connexion.entities.GestionLIVREUR;
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
public class LivreurCRUD {
      Connection cnx2;
    
    public  LivreurCRUD(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void addLivreur(GestionLIVREUR glv) {
        try {
            String request = "INSERT INTO ListeLivreur (IdLivreur,NomLivreur,prenomLivreur,telLivreur) VALUES(?,?,?,?) ";
            java.sql.PreparedStatement pst =cnx2.prepareStatement(request);
             
           pst.setInt(1,glv.getIdLivreur());
     
           pst.setString(2,glv.getNomLivreur());
           
           pst.setString(3,glv.getPrenomLivreur());
           
           pst.setInt(4,glv.getTelLivreur());
           
           pst.executeUpdate();
           
           
            System.out.println("la Livreur ajouté! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void updateLivreur(GestionLIVREUR glv) {
        try {
            String request = "UPDATE GestionLIVREUR Set IdLivreur = ?,NomLivreur = ?,prenomLivreur = ? where idLivreur = ?  ";
            PreparedStatement pst = cnx2.prepareStatement(request);
            pst.setInt(1,glv.getIdLivreur());
     
           pst.setString(2,glv.getNomLivreur());
           
           pst.setString(3,glv.getPrenomLivreur());
           
           pst.setInt(4,glv.getTelLivreur());
           
            pst.executeUpdate();
           System.out.println("Livreur modifié! ");
  
      }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }}
    public void deleteLivreur(int IdLivreur) {
        try {
            String request = "DELETE FROM ListeLivreur  where IdLivreur = ?  ";
            PreparedStatement pst = cnx2.prepareStatement(request);
            pst.setInt(1, IdLivreur);
            
            pst.executeUpdate();
           System.out.println("Livreure supprimé ! ");
  
      }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }}

   public List<GestionLIVREUR> DisplayLivreur() {
        List<GestionLIVREUR> myList = new ArrayList();
        try {
            String request = "Select * from ListeLivreur";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet res = st.executeQuery(request);

            while (res.next()) {
                GestionLIVREUR glv = new GestionLIVREUR();
               glv.setIdLivreur(res.getInt(1));
                glv.setNomLivreur(res.getString(2));
                glv.setPrenomLivreur(res.getString(3));
                glv.setTelLivreur(res.getInt(4));

                myList.add(glv);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    
}




    


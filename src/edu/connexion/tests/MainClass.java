/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion.tests;

import edu.connexion.entities.GestiondeLivraison;
import edu.connexion.entities.Livraison;
import edu.connexion.entities.Livreur;
import edu.connexion.services.LivraisonCRUD;
import edu.connexion.services.LivreurCRUD;
import edu.connexion.utils.MyConnection;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.Document;

/**
 *
 * @author islemferchichi
 */
 public class MainClass {
 public static void main(String[]args){
        
    
   MyConnection mc = MyConnection.getInstance();   
   MyConnection mc2 = MyConnection.getInstance();  
   System.out.println(mc.hashCode()+" - "+mc2.hashCode());
    LivraisonCRUD lcd = new LivraisonCRUD();
    //Livraison l4=new Livraison(1,812,"",40);
    //GestiondeLivraison l1=new GestiondeLivraison(222,"samir",30);
     Livraison l  =new Livraison(8,90,80);
    lcd.addLivraison(l);
    //lcd.deleteLivraison(444);
     //lcd.updateLivraison(l);
  
     List<Livraison>ListLivraison= lcd.DisplayLivraison();
     for(Livraison gl:ListLivraison)
     {
         System.out.println(gl);    
    
   Livreur e5= new Livreur(1,"bom","bom",52333523);
    //Livreur e1= new Livreur(803,"samir","samir",52333888);
   Livreur e3= new Livreur(90,"Monji","karmbader",52444444);
   LivreurCRUD lc = new LivreurCRUD();
    //lc.updateLivreur(e1);
   //lc.addLivreur(e5);
    //lc.updateLivreur(e);
    //lc.deleteLivreur(8100); 
    
   List<Livreur>listLiveur = lc.DisplayLivreur();
   
     for(Livreur a:listLiveur)
     
     {
         System.out.println(e3);
    }
    


     }}}
  



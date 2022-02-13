/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion.tests;
import edu.connexion.entities.GestiondeLivraison;
import edu.connexion.entities.GestionLIVREUR;
import edu.connexion.services.LivraisonCRUD;
import edu.connexion.services.LivreurCRUD;
import edu.connexion.utils.MyConnection;

import java.util.List;

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
    GestiondeLivraison l=new GestiondeLivraison("mongi",12);
   
     lcd.addLivraison(l);
     lcd.deleteLivraison(7);
     lcd.updateLivraison(l,12);
     List<GestiondeLivraison>listLivrai = lcd.DisplayLivraison();
     for(GestiondeLivraison gl:listLivrai)
     {
         System.out.println(gl);
         
    }
    
    }
  
   //GestionLIVREUR glv=new GestionLIVREUR(1,"Ben Mohamed","Karim",55111111);
    //LivreurCRUD lc = new LivreurCRUD();
    //GestionLIVREUR glv=new GestionLIVREUR(4,"Ben Mohamed","Karim",55111111);
    //lc.addLivreur();
   /*List<GestionLIVREUR>listLiveur = lc.DisplayLivreur();
     for(GestionLIVREUR gl:listLiveur)
     {
         System.out.println(gl);
    }*/
    }

//public static void main(String[] args){
   // MyConnection mc =new MyConnection();
   //reservationCRUD rcd = new reservationCRUD(); 
        //reservation r2 = new reservation("ahmed", 27,4,"21-08-2002"); 
         //reservation r3 = new reservation("jjjj", 27,4,"21-08-2002"); 
       //rcd.ajouterReservation2(r3);
       // System.out.println(rcd.afficheReservation());
       // System.out.println("***********modification************");
        //rcd.modifierReservation(new reservation(4,"nesrine", 2, 5,"2000-08-21"));
       // System.out.println(rcd.afficheReservation());
         //rcd.supprimerReservation(r2);
         //System.out.println(rcd.afficheReservation());


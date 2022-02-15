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
    GestiondeLivraison l=new GestiondeLivraison(254,"samir",50);
    //GestiondeLivraison l1=new GestiondeLivraison(222,"samir",30);
    //GestiondeLivraison l2=new GestiondeLivraison(444,"bader",80);
    //lcd.addLivraison(l);
    //lcd.deleteLivraison(444);
     lcd.updateLivraison(l);
     List<GestiondeLivraison>listLivrai = lcd.DisplayLivraison();
     for(GestiondeLivraison gl:listLivrai)
     {
         System.out.println(gl);    
    
   //GestionLIVREUR e= new GestionLIVREUR(808,"mounir","mounir",52333777);
   //GestionLIVREUR e1= new GestionLIVREUR(808,"samir","sair",52333888);
  //GestionLIVREUR e2= new GestionLIVREUR(808,"bader","bader",52333999);
   //LivreurCRUD lc = new LivreurCRUD();
    
   // lc.addLivreur(e);
   // lc.updateLivreur(e);
   // lc.deleteLivreur(e); 
    
   //List<GestionLIVREUR>listLiveur = lc.DisplayLivreur();
   
     //for(GestionLIVREUR kk:listLiveur)
     
     //{
     //    System.out.println(kk);
    //}
    


{Scanner clavier=new Scanner(System.in);
        double HT=0,tva=0,r=0,netc=0,ttc=0;
        System.out.println("entrer N");
           int n=clavier.nextInt();
           for(int i=0;i<n;i++){
            System.out.println("Entrer prix");
            double prix=clavier.nextDouble();
            HT+=prix;}
        if(HT>100){
        r=HT*0.1; 
        netc=HT-r;
        }
        tva=netc*0.2;
        ttc=netc+tva;
        
       
    System.out.println("le montant est" +HT+"dinars");
    System.out.println("La remise 1% est"+r+"dinars");
    System.out.println("net commercial est"+netc+"dinars");
    System.out.println("TVA est"+tva+"dinars");

     }}}}
  



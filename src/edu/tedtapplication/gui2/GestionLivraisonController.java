/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tedtapplication.gui2;

import edu.connexion.entities.Livraison;
import edu.connexion.entities.Livreur;
import edu.connexion.services.LivraisonCRUD;
import edu.connexion.services.LivreurCRUD;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javax.swing.JTable;




/**
 * FXML Controller class
 *
 * @author islemferchichi
 */
public class GestionLivraisonController implements Initializable {
String action;
    @FXML
    private TableView<Object> tabLivraison;
    @FXML
    private TableColumn<Livraison, Integer> idlivraison;
    @FXML
    private TableColumn<Livraison, Integer> idlivreur;
    @FXML
    private TableColumn<Livraison, Double> prixLiv;
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private Pane formliv;
    @FXML
    private Button backbtn;
    @FXML
    private TextField idinput;
    @FXML
    private TextField idliv;
    @FXML
    private TextField pricliv;
    @FXML
    private Button save;
    @FXML
    private Label erreur;
    @FXML
    private Button imprimbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       formliv.setOpacity(0);


        ObservableList<Object> listdata = FXCollections.observableArrayList();
        // pour tableview naccepte ke les  observableliste
        
         
         
        idlivraison.setCellValueFactory(new PropertyValueFactory<>("IdLivraison"));
        idlivreur.setCellValueFactory(new PropertyValueFactory<>("IdLivreur"));
        prixLiv.setCellValueFactory(new PropertyValueFactory<>("FraisdeLivraison"));
        LivraisonCRUD lc = new LivraisonCRUD();
        listdata.addAll(lc.DisplayLivraison());
        tabLivraison.setItems(listdata);
        edit.setDisable(true);
                delete.setDisable(true);
        ObservableList selectedCells = tabLivraison.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                Livraison livselected = (Livraison) tabLivraison.getSelectionModel().getSelectedItem();
                if(livselected!=null){
                  edit.setDisable(false);
                delete.setDisable(false);
                }
                else{
            edit.setDisable(true);
                delete.setDisable(true);
               }
            }
           
        });
    }
    public void refreshLivraison(){
      ObservableList<Object> listdata = FXCollections.observableArrayList();
      idlivraison.setCellValueFactory(new PropertyValueFactory<>("IdLivraison"));
        idlivreur.setCellValueFactory(new PropertyValueFactory<>("IdLivreur"));
        prixLiv.setCellValueFactory(new PropertyValueFactory<>("FraisdeLivraison"));
        LivraisonCRUD lc = new LivraisonCRUD();
               listdata.addAll(lc.DisplayLivraison());
        tabLivraison.setItems(listdata);

    }    

   @FXML
    private void backtogestionLiv(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gestionlivreur.fxml"));
            Parent root = loader.load();
            GestionlivreurController dpc = loader.getController();

            backbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addLiv(ActionEvent event) {
         formliv.setOpacity(1);
         action="add";
         idinput.setText("");
         pricliv.setText("");
         idliv.setText("");
         
        
    }

    @FXML
    
    private void editLiv(ActionEvent event) {
       Livraison livselected = (Livraison) tabLivraison.getSelectionModel().getSelectedItem();
        formliv.setOpacity(1);
        action="Edit";
        idinput.setText(String.valueOf(livselected.getIdLivraison()));
        pricliv.setText(String.valueOf(livselected.getFraisdeLivraison()));
        idliv.setText(String.valueOf(livselected.getIdLivreur()));

        idinput.setDisable(true);
        
        
    }

    @FXML
    private void DeleteLiv(ActionEvent event) {
        Livraison livselected = (Livraison) tabLivraison.getSelectionModel().getSelectedItem();
        LivraisonCRUD lc = new LivraisonCRUD();
        lc.deleteLivraison(livselected.getIdLivraison());
                refreshLivraison();

    }

    @FXML
    private void savebutton(ActionEvent event) {
        if(idinput.getText().compareTo("")==0||pricliv.getText().compareTo("")==0||idliv.getText().compareTo("")==0){
        erreur.setText("erreur");
        } //si les inputs far8in affichi erreur
        else{
                    erreur.setText("");

                                LivraisonCRUD lc = new LivraisonCRUD();

            //si l'action est ajouter 
            if(action.compareTo("add")==0){
            Livraison l =new Livraison(Integer.valueOf(idinput.getText()),Integer.valueOf(idliv.getText()),Double.valueOf(pricliv.getText()));
            lc.addLivraison(l);
            }else{
                //si l'action est modification
              Livraison livraisonselected = (Livraison) tabLivraison.getSelectionModel().getSelectedItem(); //livraison selected from tableview
              livraisonselected.setFraisdeLivraison(Double.valueOf(pricliv.getText())); //modifier 
              livraisonselected.setIdLivreur(Integer.valueOf(idliv.getText())); //modifier
             lc.updateLivraison(livraisonselected);
             
            }
                    refreshLivraison();

        }
        
    }

    @FXML
    private void printtliv(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.tabLivraison;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
    }
       
         refreshLivraison();
        }}}

    


    
         
    

   

        
    
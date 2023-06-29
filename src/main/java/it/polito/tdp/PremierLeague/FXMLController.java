/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.PremierLeague.model.Match;
import it.polito.tdp.PremierLeague.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnConnessioneMassima"
    private Button btnConnessioneMassima; // Value injected by FXMLLoader

    @FXML // fx:id="btnCollegamento"
    private Button btnCollegamento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinuti"
    private TextField txtMinuti; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMese"
    private ComboBox<String> cmbMese; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM1"
    private ComboBox<?> cmbM1; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM2"
    private ComboBox<?> cmbM2; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    
    private Graph<Match, DefaultWeightedEdge> grafo;
    private int mese;
    
    @FXML
    void doConnessioneMassima(ActionEvent event) {
    	
    	for(DefaultWeightedEdge i : this.model.getMax()) {
    		this.txtResult.appendText("[ " + this.grafo.getEdgeSource(i).getMatchID() + " ]" +this.grafo.getEdgeSource(i).getTeamHomeNAME() +" vs " +this.grafo.getEdgeSource(i).getTeamAwayNAME() + " \n"+ "[ " + this.grafo.getEdgeTarget(i).getMatchID() + " ]" + " " + this.grafo.getEdgeTarget(i).getTeamHomeNAME() +" vs " +this.grafo.getEdgeTarget(i).getTeamAwayNAME() +"\n");
    	}
    	
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	if(this.cmbMese.getValue()=="Gennaio") {
    		mese =1;
    	}else if(cmbMese.getValue()=="Febbraio") {
			mese = 2;
		}if(cmbMese.getValue()=="Marzo") {
			mese = 3;
		}if(cmbMese.getValue()=="Aprile") {
			mese = 4;
		}if(cmbMese.getValue()=="Maggio") {
			mese = 5;
		}if(cmbMese.getValue()=="Giugno") {
			mese = 6;
		}if(cmbMese.getValue()=="Luglio") {
			mese = 7;
		}if(cmbMese.getValue()=="Agosto") {
			mese = 8;
		}if(cmbMese.getValue()=="Settembre") {
			mese = 9;
		}if(cmbMese.getValue()=="Ottobre") {
			mese = 10;
		}if(cmbMese.getValue()=="Novembre") {
			mese = 11;
		}if(cmbMese.getValue()=="Dicembre") {
			mese = 12;
		}
    	
		Integer minuti = Integer.parseInt(this.txtMinuti.getText());
    	
    	this.grafo = this.model.creaGrafo(mese, minuti);
    	
    	
    	this.txtResult.setText("#VERTICI: " + this.grafo.vertexSet().size()+"\n#ARCHI: "+this.grafo.edgeSet().size() +"\n");
    }

    @FXML
    void doCollegamento(ActionEvent event) {
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConnessioneMassima != null : "fx:id=\"btnConnessioneMassima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCollegamento != null : "fx:id=\"btnCollegamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinuti != null : "fx:id=\"txtMinuti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMese != null : "fx:id=\"cmbMese\" was not injected: check your FXML file 'Scene.fxml'.";        assert cmbM1 != null : "fx:id=\"cmbM1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbM2 != null : "fx:id=\"cmbM2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	
    	
		this.cmbMese.getItems().add("Gennaio");
		this.cmbMese.getItems().add("Febbraio");
		this.cmbMese.getItems().add("Marzo");
		this.cmbMese.getItems().add("Aprile");
		this.cmbMese.getItems().add("Maggio");
		this.cmbMese.getItems().add("Giugno");
		this.cmbMese.getItems().add("Luglio");
		this.cmbMese.getItems().add("Agosto");
		this.cmbMese.getItems().add("Settembre");
		this.cmbMese.getItems().add("Ottobre");
		this.cmbMese.getItems().add("Novembre");
		this.cmbMese.getItems().add("Dicembre");

		
		
		
    }
    
    
}

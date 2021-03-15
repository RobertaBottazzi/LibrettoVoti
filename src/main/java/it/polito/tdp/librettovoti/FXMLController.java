package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class FXMLController implements Initializable {
    
	private Libretto model;
	
    @FXML
    private Label label;
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField  txtNomeEsame;

    @FXML
    private TextField  txtVoto;
    
    @FXML
    private DatePicker pickerEsame;

    //@FXML
    //private TextField  txtData;
    
    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Leggi e controlla i dati
    	String nomeEsame=txtNomeEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return; //esce e non fa l'operazione sul model che va a modificare i dati essendo questi non validi
    	}
    	String votoEsame=txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt= Integer.parseInt(votoEsame);
    	} catch(NumberFormatException ex) {
    		txtResult.setText("ERRORE: il voto deve essere un numero");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}   	
    	
    	/*String dataEsame= txtData.getText();
    	LocalDate data;
    	try {
    		data=LocalDate.parse(dataEsame);
    	} catch(DateTimeParseException ex) {
    		txtResult.setText("ERRORE: il la data deve essere valida");
    		return;
    	}*/
    	LocalDate data=pickerEsame.getValue();
    	if(data==null) {
    		txtResult.setText("ERRORE: la data deve è errata o mancante"); //su scenebuilder mettendo il campo non editabile risolvo il problema di inserire date non valide
    		return;
    	}
    	
    	//TODO: aggiungere tutti i controlli
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//Aggiorna i risultati (nella view)
    	txtResult.setText(model.toString());
    	txtNomeEsame.clear();
    	txtVoto.clear();
    	//txtData.clear();
    	pickerEsame.setValue(null);    	
    }
    
    public void setModel(Libretto model) {
    	this.model= model;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 assert txtNomeEsame != null : "fx:id=\"txtNomeEsame\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        // assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
         assert pickerEsame != null : "fx:id=\"pickerData\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";  
    } 
    
    
}

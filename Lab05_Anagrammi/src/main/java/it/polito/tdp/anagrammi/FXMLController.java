package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model modello;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtInput"
	private TextField txtInput; // Value injected by FXMLLoader

	@FXML // fx:id="btnCalcola"
	private Button btnCalcola; // Value injected by FXMLLoader

	@FXML // fx:id="txtParoleCorrette"
	private TextArea txtParoleCorrette; // Value injected by FXMLLoader

	@FXML // fx:id="txtParoleSbagliate"
	private TextArea txtParoleSbagliate; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private Button btnReset; // Value injected by FXMLLoader

	@FXML
	void calcolaAnagrammi(ActionEvent event) {
	txtParoleCorrette.clear();
	txtParoleSbagliate.clear();
	String parola = txtInput.getText();
	this.modello.setListe(this.modello.anagramma(parola));

	for (String s : this.modello.getParoleGiuste()) {
		txtParoleCorrette.appendText(s+"\n");
	}
	
	for (String c : this.modello.getParoleSbagliate()) {
		txtParoleSbagliate.appendText(c+"\n");
	}
	
	}

	@FXML
	void clear(ActionEvent event) {
		txtParoleCorrette.clear();
		txtParoleSbagliate.clear();
		txtInput.clear();

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtParoleCorrette != null
				: "fx:id=\"txtParoleCorrette\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtParoleSbagliate != null
				: "fx:id=\"txtParoleSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.modello = model;

	}
}

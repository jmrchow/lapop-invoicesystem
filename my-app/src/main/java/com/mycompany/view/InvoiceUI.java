package com.mycompany.view;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InvoiceUI {
	
	private static final int NUMBER_OF_LINES = 6;
	
	@FXML
	private GridPane gridpane0;
	@FXML
	private Button btn;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
    }

	
	
	public void initInvoiceUI() throws Exception {
		Stage invoiceStage = new Stage();
		
		Parent root = FXMLLoader.load(InvoiceUI.class.getResource("FXMLInvoicePage.fxml"));


		

		


		Scene scene = new Scene(root, 800, 600);
		invoiceStage.setScene(scene);


		invoiceStage.setTitle("Invoice");

		invoiceStage.show();
		

	}
	
	public void initialize() {
		TextField dateField = new TextField();
		gridpane0.add(dateField, 0, 1);

		TextField[] itemFields = new TextField[NUMBER_OF_LINES];
		TextField[] descriptionFields = new TextField[NUMBER_OF_LINES];
		TextField[] quantityFields = new TextField[NUMBER_OF_LINES];
		TextField[] priceFields = new TextField[NUMBER_OF_LINES];
		TextField[] discountFields = new TextField[NUMBER_OF_LINES];

		for (int i = 0; i < NUMBER_OF_LINES; i++) {
			itemFields[i] = new TextField();
			descriptionFields[i] = new TextField();
			quantityFields[i] = new TextField();
			priceFields[i] = new TextField();
			discountFields[i] = new TextField();
			
			gridpane0.add(itemFields[i], 1, i+1);
			gridpane0.add(descriptionFields[i], 2, i+1);
			gridpane0.add(quantityFields[i], 3, i+1);
			gridpane0.add(priceFields[i], 4, i+1);
			gridpane0.add(discountFields[i], 5, i+1);
			
		}
	}

//	public static InvoiceDTO getInvoiceData() { // TODO: Make InvoiceDTO class
//		
//		LinkedList<String> itemsList =  new LinkedList<String>();
//		LinkedList<String> descriptionsList =  new LinkedList<String>();
//		LinkedList<Integer> quantityList =  new LinkedList<Integer>();
//		LinkedList<Integer> priceList =  new LinkedList<Integer>(); 
//		LinkedList<Integer> discountList =  new LinkedList<Integer>();
//		
//
//		for (int i = 0; i < 6; i++) {
//			if (!"da")
//		}
//		
//		InvoiceDTO specificInvoiceDTO = new InvoiceDTO();
//		InvoiceDTO.invoiceDate = date;
//		InvoiceDTO.invoiceItems = itemsList;
//		InvoiceDTO.invoiceDescriptions = descriptionsList;
//		
//	}
}

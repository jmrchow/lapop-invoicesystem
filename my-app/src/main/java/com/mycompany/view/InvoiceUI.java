package com.mycompany.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import com.mycompany.controller.InvoiceSystemController;

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
	
	public static final int NUMBER_OF_LINES = 6;
	
	@FXML
	private GridPane gridpane0;
	@FXML
	private Button btn;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
    	try {
			InvoiceSystemController.createInvoice(getInvoiceData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	TextField[] itemFields;
	TextField[] descriptionFields;
	TextField[] quantityFields;
	TextField[] priceFields;
	TextField[] discountFields;
	
	
	public void initInvoiceUI() throws Exception {
		Stage invoiceStage = new Stage();
		
		Parent root = FXMLLoader.load(InvoiceUI.class.getResource("FXMLInvoicePage.fxml"));


		

		


		Scene scene = new Scene(root, 800, 600);
		invoiceStage.setScene(scene);


		invoiceStage.setTitle("Invoice");

		invoiceStage.show();
		

	}
	
	@FXML
	private void initialize() {
		TextField dateField = new TextField();
		gridpane0.add(dateField, 0, 1);

		itemFields = new TextField[NUMBER_OF_LINES];
		descriptionFields = new TextField[NUMBER_OF_LINES];
		quantityFields = new TextField[NUMBER_OF_LINES];
		priceFields = new TextField[NUMBER_OF_LINES];
		discountFields = new TextField[NUMBER_OF_LINES];

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

	public InvoiceDTO getInvoiceData() {
		InvoiceDTO specificInvoiceDTO = new InvoiceDTO();
		for (int i = 0; i < NUMBER_OF_LINES; i++) {
			if (!itemFields[i].getText().equals("")) {
				specificInvoiceDTO.addBundle(i, itemFields[i].getText(), descriptionFields[i].getText(), Integer.parseInt(quantityFields[i].getText())
						, Integer.parseInt(priceFields[i].getText()), Integer.parseInt(discountFields[i].getText()));
			}
		}
		return specificInvoiceDTO;

	}
}

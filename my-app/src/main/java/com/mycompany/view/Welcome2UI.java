package com.mycompany.view;

import com.mycompany.controller.InvoiceSystemController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Welcome2UI {
	@FXML
	private GridPane gridpane0;
	@FXML
	private Button btn1;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
    	InvoiceUI InvoiceUIController = new InvoiceUI();
		try {
			InvoiceUIController.initInvoiceUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@FXML
	private Button btn2;
    @FXML protected void handleSubmitButtonAction2(ActionEvent event) {
    	NewCustomerUI NewCustomerUIController = new NewCustomerUI();
    	try {
			NewCustomerUIController.initNewCustomerUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
	public void initWelcome2UI() throws Exception {
		Stage invoiceStage = new Stage();
		
		Parent root = FXMLLoader.load(InvoiceUI.class.getResource("FXMLWelcome2Page.fxml"));


		

		


		Scene scene = new Scene(root, 800, 600);
		invoiceStage.setScene(scene);


		invoiceStage.setTitle("Welcome");

		invoiceStage.show();
		

	}
}

package com.mycompany.view;

import java.io.IOException;

import com.mycompany.controller.InvoiceSystemController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewCustomerUI {
	
	TextField companyNameField;
	TextField contactNameField;
	TextField address1Field;
	TextField address2Field;
	TextField cityField;
	TextField provinceField;
	TextField postalCodeField;
	
	@FXML
	private GridPane gridpane0;
	@FXML
	private Button btn;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
    	InvoiceSystemController.createCustomer(getNewCustomerData());
    }
    
    
    
	public void initNewCustomerUI() throws Exception {
		Stage invoiceStage = new Stage();
		
		Parent root = FXMLLoader.load(InvoiceUI.class.getResource("FXMLNewCustomerPage.fxml"));


		

		


		Scene scene = new Scene(root, 800, 600);
		invoiceStage.setScene(scene);


		invoiceStage.setTitle("New Customer");

		invoiceStage.show();
		

	}
	
	@FXML
	private void initialize() {
		companyNameField = new TextField();
		contactNameField = new TextField();
		address1Field = new TextField();
		address2Field = new TextField();
		cityField = new TextField();
		provinceField = new TextField();
		postalCodeField = new TextField();
		
		gridpane0.add(companyNameField, 0, 1);
		gridpane0.add(contactNameField, 1, 1);
		gridpane0.add(address1Field, 2, 1);
		gridpane0.add(address2Field, 3, 1);
		gridpane0.add(cityField, 4, 1);
		gridpane0.add(provinceField, 5, 1);
		gridpane0.add(postalCodeField, 6, 1);

	}
	
	public CustomerDTO getNewCustomerData() {
		CustomerDTO customerDTO = new CustomerDTO(
				companyNameField.getText(),
				contactNameField.getText(),
				address1Field.getText(),
				address2Field.getText(),
				cityField.getText(),
				provinceField.getText(),
				postalCodeField.getText());
		return customerDTO;
		
	}

}

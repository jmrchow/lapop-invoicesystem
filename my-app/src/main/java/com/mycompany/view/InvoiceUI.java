package com.mycompany.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InvoiceUI {
	
	@FXML
	static TextField date0;
	
	
	
	public static void initInvoiceUI() throws Exception {
		Stage invoiceStage = new Stage();
		
		Parent root = FXMLLoader.load(InvoiceUI.class.getResource("FXMLInvoicePage.fxml"));

		Scene scene = new Scene(root, 800, 600);
		invoiceStage.setScene(scene);
//		System.out.println(date0.getText());

		invoiceStage.setTitle("Invoice");
		invoiceStage.show();
	}

}

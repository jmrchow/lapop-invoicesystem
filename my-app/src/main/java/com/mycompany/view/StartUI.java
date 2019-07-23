package com.mycompany.view;
import java.io.IOException;

import com.mycompany.controller.InvoiceSystemController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@SuppressWarnings("restriction")
public class StartUI extends Application {
	
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	public static void main(String[] args) {
		launch(args);
//		try {
//			InvoiceSystemController.createInvoice();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	@Override
	public void start(Stage primaryStage){
		initLoginUI(primaryStage);
	}
	
	private void initLoginUI(final Stage primaryStage) {
		primaryStage.setTitle("JavaFX Welcome");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Login");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle,  0,  0, 2, 1);
		
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		
		final TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		Label pw = new Label("Password: ");
		grid.add(pw, 0, 2);
		
		final PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);
			
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Sign in button pressed");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (userTextField.getText().contentEquals(USERNAME) && pwBox.getText().equals(PASSWORD)) {
					primaryStage.close();
					try {
						InvoiceUI.initInvoiceUI();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else actiontarget.setText("Invalid username or password");
		
		

			}
		});
			
		Scene scene = new Scene(grid, 300, 275);
		
		primaryStage.setScene(scene);
		
		try {
			scene.getStylesheets().add("com/mycompany/view/Login.css");
		}
		catch(Exception e){
			System.out.println("oops");
		}
		primaryStage.show();
		
	}
	
}

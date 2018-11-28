package com.advancedb.mainview;

/**
 * @author Roger Cruz
 * 11/28/2018
 * 
 * This class will control the Home Screen.
 * 
 * */

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeController {

	@FXML protected void goToMainScene() throws IOException
	{	
		try
		{				
			// Get the scene from the fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../addEmp/AddEmployee.fxml"));
			BorderPane updateJobPane = (BorderPane)loader.load();
			Scene scene = new Scene(updateJobPane);
			Stage stage = new Stage();
			stage.setTitle("Update Job");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML protected void exitSystem() throws IOException
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exiting FloJo-Aide");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to exit?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			System.exit(0);
		}
		else
		{
			alert.close();
		}
	}	
	
}

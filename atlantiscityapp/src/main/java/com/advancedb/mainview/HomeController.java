package com.advancedb.mainview;
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

/**
 * @author Roger Cruz
 * 11/28/2018
 * 
 * This class will control the Home Screen.
 * 
 * */
public class HomeController 
{
	@FXML protected void goToAddCustomerScene() throws IOException
	{	
		try
		{				
			// Get the scene from the fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../addCustomer/AddCustomer.fxml"));
			BorderPane updateJobPane = (BorderPane)loader.load();
			Scene scene = new Scene(updateJobPane);
			Stage stage = new Stage();
			stage.setTitle("Add Customer");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML protected void goToAddInventoryScene() throws IOException
	{	
		try
		{				
			// Get the scene from the fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../addInventory/AddInventory.fxml"));
			BorderPane updateJobPane = (BorderPane)loader.load();
			Scene scene = new Scene(updateJobPane);
			Stage stage = new Stage();
			stage.setTitle("Add Inventory");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML protected void goToManageCustomerScene() throws IOException
	{	
		try
		{				
			// Get the scene from the fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../manageCustomer/manageCustomer.fxml"));
			BorderPane updateJobPane = (BorderPane)loader.load();
			Scene scene = new Scene(updateJobPane);
			Stage stage = new Stage();
			stage.setTitle("Manage Customers");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML protected void goToManageInventoryScene() throws IOException
	{	
		try
		{				
			// Get the scene from the fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../manageInventory/manageInventory.fxml"));
			BorderPane updateJobPane = (BorderPane)loader.load();
			Scene scene = new Scene(updateJobPane);
			Stage stage = new Stage();
			stage.setTitle("Manage Inventory");
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
		alert.setTitle("Exiting Atlantis City Bowling");
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

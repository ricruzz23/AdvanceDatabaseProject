package com.advancedb.atlantiscityapp;

/**
 * @author Roger Cruz
 * 11/28/2018
 * 
 * This class is the Application's launch.
 * 
 * */

import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main( String[] args )
    {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub
		try
		{
			this.primaryStage = primaryStage;
			showHomeScene();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void showHomeScene() throws IOException
	{
		
		// Get the scene from the fxml file
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../mainview/home.fxml"));
				mainLayout = loader.load();
				Scene scene = new Scene(mainLayout, 1100, 600);
				primaryStage.setTitle("Atlantis City Bowling Alley");
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	// Private Data Members
		private Stage primaryStage;
		private static BorderPane mainLayout;
}

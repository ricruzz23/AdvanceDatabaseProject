package com.advancedb.addInventory;



import java.util.Optional;

/**
 * @author Padmaja Parise
 * 12/01/2018
 * 
 * This class will control the Add Inventory Screen.
 * 
 * */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.advancedb.utilClasses.Customers;
import com.advancedb.utilClasses.Inventory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddInventoryController {
	@FXML
	private TextField gender;
	@FXML
	private TextField shoewidth;
	@FXML
	private TextField shoesize;
	@FXML
	private TextField agegroup;

	// Event Listener on Button.onAction
	@FXML
	protected void addInventoryToDB(ActionEvent event) {
		
		Inventory shoe = new Inventory();
		shoe.setCharShoesGender(gender.getText());
		shoe.setCharShoesShoewidth(shoewidth.getText());
		shoe.setDbShoesShoesize(shoesize.getText());
		shoe.setCharShoesAgegroup(agegroup.getText());

		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Inventory.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(shoe);
		
		tx.commit();
		
		inventoryAdded(event);
		
	}
	// Event Listener on Button.onAction
	@FXML
	protected void exitAddInventoryScreen(ActionEvent e) {
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	
	public void inventoryAdded(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Shoes Added");
		alert.setHeaderText(null);
		alert.setContentText("A pair of shoes were Added to System.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			stage.close();
		}
		else
		{
			alert.close();
		}
	}
	
	
}
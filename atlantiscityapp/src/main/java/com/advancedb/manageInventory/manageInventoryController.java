package com.advancedb.manageInventory;

/**
 * @author Padmaja Parise
 * 12/8/2018
 * 
 * This class will control the Manage Inventory Screen.
 * 
 * */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.advancedb.utilClasses.Inventory;

public class manageInventoryController {
	@FXML
	private TextField shoesize;
	@FXML
	private TableView tableView;

	
	@FXML
	public void initialize() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public void loadAllInventory()
	{
		Inventory shoe = new Inventory();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Inventory.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		ObservableList<Inventory> observList = (ObservableList<Inventory>) new ArrayList();
		
		//observList = session.get
		
		
		tx.commit();
		
		//inventoryAdded(event);
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void updateInventory(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void retireInventory(ActionEvent event) {
		// TODO Autogenerated
	}
}
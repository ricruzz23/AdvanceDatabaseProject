package com.advancedb.addCustomer;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.advancedb.utilClasses.Customers;

/**
 * @author Roger Cruz
 * 11/28/2018
 * 
 * This class will control the Add Customer Screen.
 * 
 * */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {
	@FXML
	private TextField firstName;
	@FXML
	private TextField LastName;
	@FXML
	private TextField Phone;
	@FXML
	private TextField email;

	// Event Listener on Button.onAction
	@FXML
	protected void addEmpToDB(ActionEvent event) {
		
		
		
		Customers cust = new Customers();
		cust.setCustomers_lastName("Cruz");
		cust.setCustomer_firstName("Roger");
		cust.setCustomers_phoneNumber(1234567788);
		cust.setCustomers_Email("roger@gmail.com");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(cust);
		
		tx.commit();
		
	}
	// Event Listener on Button.onAction
	@FXML
	protected void exitAddEmpScreen(ActionEvent e) {
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
}

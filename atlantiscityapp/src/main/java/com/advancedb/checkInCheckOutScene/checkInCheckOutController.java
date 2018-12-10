package com.advancedb.checkInCheckOutScene;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.advancedb.utilClasses.Customers;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

public class checkInCheckOutController {
	@FXML
	private TextField searchCustID;
	@FXML
	private TextField custID;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;
	@FXML
	private TableView tableViewAvailableToCheckout;
	@FXML
	private TableView tableViewCustomerHasCheckedout;
	
	Customers activeCustomer;

	@FXML
	public void searchCustomer(ActionEvent event)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction();
		Integer customerID = Integer.valueOf(searchCustID.getText());
		
		activeCustomer = session.get(Customers.class, customerID);
		loadCustomerFromSearch(activeCustomer);
	}
	
	public void loadCustomerFromSearch(Customers cust)
	{
		custID.setText(cust.getCustomers_customerID().toString());
		firstName.setText(cust.getCustomer_firstName());
		lastName.setText(cust.getCustomers_lastName());
		phone.setText(cust.getCustomers_phoneNumber().toString());
		email.setText(cust.getCustomers_email());
	}
	
	@FXML
	public void returnToInventory(ActionEvent event) 
	{
		
	}
	
	@FXML
	public void checkOut(ActionEvent event) 
	{
		
	}
	
}

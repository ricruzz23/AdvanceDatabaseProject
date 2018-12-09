package com.advancedb.updateCustomer;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.advancedb.utilClasses.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**@ Roger Cruz
@ 12/9/2018
@ This class controls the Customer Update Screen
*/

public class UpdateCustomerController
{
	@FXML
	public void UpdateCustomerToDB(ActionEvent event) throws ClassNotFoundException, SQLException, ParseException 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction();

			updatedCustomerInfo = new Customers();
			updatedCustomerInfo.setCustomers_customerID(inComingCustomerInfo.getCustomers_customerID());
			updatedCustomerInfo.setCustomer_firstName(firstName.getText());
			updatedCustomerInfo.setCustomers_lastName(lastName.getText());
			Long p = Long.valueOf(phone.getText());
			updatedCustomerInfo.setCustomers_phoneNumber(p);
			updatedCustomerInfo.setCustomers_email(email.getText());
			updatedCustomerInfo.setCustomers_registrationDate(inComingCustomerInfo.getCustomers_registrationDate());
			updatedCustomerInfo.setCustomers_deactiveDate(inComingCustomerInfo.getCustomers_deactiveDate());
			updatedCustomerInfo.setCustomers_deactive(inComingCustomerInfo.getCustomers_deactive());
		
		Customers cust2 = session.get(Customers.class, inComingCustomerInfo.getCustomers_customerID());
		
		if(inComingCustomerInfo.equals(cust2))
		{
			//Do nothing. Both customer copies are identical no need to update record.
		}
		else
		{
			session.merge(updatedCustomerInfo);
		}
		
		tx.commit();
		session.clear();
		session.close();
		sf.close();
		
		updateSuccessfull(event);
	}

	@FXML
	public void exitUpdateCustomerScreen(ActionEvent e) 
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void setInfo(Customers cust) throws ClassNotFoundException
	{
		inComingCustomerInfo = cust;
		custID.setText(cust.getCustomers_customerID().toString());
		firstName.setText(cust.getCustomer_firstName());
		lastName.setText(cust.getCustomers_lastName());
		phone.setText(cust.getCustomers_phoneNumber().toString());
		email.setText(cust.getCustomers_email());
	}
	
	public void updateSuccessfull(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Update Successfull");
		alert.setHeaderText(null);
		alert.setContentText("The customer's information has been updated");

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
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
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
	
	private Customers inComingCustomerInfo;
	private Customers updatedCustomerInfo;
}

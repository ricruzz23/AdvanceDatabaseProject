package com.advancedb.addCustomer;



import java.util.Optional;

/**
 * @author Roger Cruz
 * 11/28/2018
 * 
 * This class will control the Add Customer Screen.
 * 
 * */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.advancedb.utilClasses.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddCustomerController {
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;

	// Event Listener on Button.onAction
	@FXML
	protected void addCustomerToDB(ActionEvent event) {
		
		Customers cust = new Customers();
		cust.setCustomers_lastName(lastName.getText());
		cust.setCustomer_firstName(firstName.getText());
		cust.setCustomers_phoneNumber(Long.valueOf(phone.getText()));
		cust.setCustomers_Email(email.getText());
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(cust);
		
		tx.commit();
		
		customerAdded(event);
		
	}
	// Event Listener on Button.onAction
	@FXML
	protected void exitAddCustomerScreen(ActionEvent e) {
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	
	public void customerAdded(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Customer Added");
		alert.setHeaderText(null);
		alert.setContentText("Customer was Added to System.");

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

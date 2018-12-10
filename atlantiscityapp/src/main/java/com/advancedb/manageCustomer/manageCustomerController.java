package com.advancedb.manageCustomer;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.advancedb.atlantiscityapp.App;
import com.advancedb.updateCustomer.UpdateCustomerController;
import com.advancedb.utilClasses.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Roger Cruz
 * 12/2/2018
 * 
 * This class will control the Manage Customer Screen.
 * 
 * */
public class manageCustomerController 
{
	@FXML
	public void initialize() throws ClassNotFoundException, SQLException, ParseException
	{
		listAllCustomers.clear();
		loadAllCustomers();
	}
	
	@FXML
	public void loadAllCustomers() throws ParseException
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("SELECT customers_customerID, "
											+ "customers_lastName, "
											+ "customer_firstName, "
											+ "customers_phoneNumber, "
											+ "customers_email, "
											+ "customers_registrationDate "
											+ "FROM customers "
											+ "WHERE customers_deactive = 0");
		
		
		List<Object[]> customers = (List<Object[]>) q.list();
		
		for(Object[] customer : customers)
		{
			String sdate = customer[5].toString();
			//SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			LocalDate date = LocalDate.parse(sdate);
			
			Customers customer1 = new Customers();
			customer1.setCustomers_customerID(Integer.valueOf(customer[0].toString()));
			customer1.setCustomers_lastName(customer[1].toString());
			customer1.setCustomer_firstName(customer[2].toString());
			customer1.setCustomers_phoneNumber(Long.valueOf(customer[3].toString()));
			customer1.setCustomers_email(customer[4].toString());
			customer1.setCustomers_registrationDate(date);
			listAllCustomers.add(customer1);
		}
		
		tx.commit();
		Collections.reverse(listAllCustomers);
		tableView.setItems(listAllCustomers);
		
		session.clear();
		session.close();
		sf.close();
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void updateCustomer(ActionEvent event) throws IOException
	{
		
		if(tableView.getSelectionModel().getSelectedItem() == null)
		{
			selectCustomer(event);
		}
		else
		{
			Customers cust = tableView.getSelectionModel().getSelectedItem();
			loadUpdateScene(cust);
		}
	}
	
	private void loadUpdateScene(Customers cust) throws IOException
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(App.class.getResource("../updateCustomer/UpdateCustomer.fxml"));
			BorderPane updateCustomer = (BorderPane)loader.load();
			
			UpdateCustomerController updateCustController = loader.getController();
			updateCustController.setInfo(cust);
			
			Scene scene = new Scene(updateCustomer);
			Stage stage = new Stage();
			stage.setTitle("Update Customer");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	// Event Listener on Button.onAction
	@FXML
	public void deactivateCustomer(ActionEvent event) throws ParseException 
	{
		if(tableView.getSelectionModel().getSelectedItem() == null)
		{
			selectCustomer(event);
		}
		else
		{
			Customers cust = tableView.getSelectionModel().getSelectedItem();
			Configuration con = new Configuration().configure().addAnnotatedClass(Customers.class);
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession(); 
			Transaction tx = session.beginTransaction();
			cust.setCustomers_deactive(1);
			LocalDate date = LocalDate.now();
			cust.setCustomers_deactiveDate(date);
			session.update(cust);
			tx.commit();
			customerDeleted(event);
			listAllCustomers.clear();
			session.clear();
			session.close();
			sf.close();
			loadAllCustomers();
		}
		
	}
	@FXML
	public void refreshList(ActionEvent event)  throws ClassNotFoundException, SQLException, ParseException
	{
		initialize();
	}
	
	@FXML
	public void closeScene(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void customerDeleted(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Customer Deleted");
		alert.setHeaderText(null);
		alert.setContentText("Customer was Deleted from the system.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			alert.close();
		}
		else
		{
			alert.close();
		}
	}
	
	public void selectCustomer(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Customer Not Selected");
		alert.setHeaderText(null);
		alert.setContentText("No customer has been selected from the list");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			alert.close();
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
	private ListView<Customers> listView;
	@FXML
	private TableView<Customers> tableView;
	@FXML
	private TextField phone;
	@FXML
	private ObservableList<Customers> listAllCustomers = FXCollections.observableArrayList();
}
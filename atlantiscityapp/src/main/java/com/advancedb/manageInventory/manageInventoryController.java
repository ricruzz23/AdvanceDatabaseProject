package com.advancedb.manageInventory;

/**
 * @author Padmaja Parise
 * 12/9/2018
 * 
 * This class will control the Manage Inventory Screen.
 * 
 * */
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.advancedb.atlantiscityapp.App;
import com.advancedb.updateInventory.UpdateInventoryController;
import com.advancedb.utilClasses.Inventory;
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


public class manageInventoryController {
	

	@FXML
	public void initialize() throws ClassNotFoundException, SQLException, ParseException
	{
		listAllShoes.clear();
		loadAllShoes();
	}
	
	@FXML
	public void loadAllShoes() throws ParseException
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Inventory.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("SELECT shoes_shoeID, "
											+ "shoes_gender, "
											+ "shoes_shoeSize, "
											+ "shoes_shoeWidth, "
											+ "shoes_ageGroup, "
											+ "shoes_isCheckedOut "
											+ "FROM shoes "
											+ "WHERE shoes_retireShoe = 0");
		
		
		List<Object[]> inventory = (List<Object[]>) q.list();
		
		for(Object[] shoe_inventory : inventory)
		{
			Inventory shoe1 = new Inventory();
			shoe1.setshoes_shoeID(Integer.valueOf(shoe_inventory[0].toString()));
			shoe1.setshoes_shoesgender(shoe_inventory[1].toString());
			shoe1.setshoes_shoeSize(shoe_inventory[2].toString());
			shoe1.setshoes_shoeWidth(shoe_inventory[3].toString());
			shoe1.setshoes_ageGroup(shoe_inventory[4].toString());
			shoe1.setshoes_isCheckedOut(Integer.valueOf(shoe_inventory[5].toString()));
			listAllShoes.add(shoe1);
		}
		
		tx.commit();
		Collections.reverse(listAllShoes);
		tableView.setItems(listAllShoes);
		
		session.clear();
		session.close();
		sf.close();
	}
	
	
	
	// Event Listener on Button.onAction
		@FXML
		public void updateInventory(ActionEvent event) throws IOException
		{
			
			if(tableView.getSelectionModel().getSelectedItem() == null)
			{
				selectShoe(event);
			}
			else
			{
				Inventory shoe = tableView.getSelectionModel().getSelectedItem();
				loadUpdateScene(shoe);
			}
		}
	
	
	private void loadUpdateScene(Inventory shoe) throws IOException
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(App.class.getResource("../updateInventory/UpdateInventory.fxml"));
			BorderPane updateInventory = (BorderPane)loader.load();
			
			UpdateInventoryController updateShoeController = loader.getController();
			updateShoeController.setInfo(shoe);
			
			Scene scene = new Scene(updateInventory);
			Stage stage = new Stage();
			stage.setTitle("Update Inventory");
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
		public void retireShoe(ActionEvent event) throws ParseException 
		{
			if(tableView.getSelectionModel().getSelectedItem() == null)
			{
				selectShoe(event);
			}
			else
			{
				Inventory shoe = tableView.getSelectionModel().getSelectedItem();
				Configuration con = new Configuration().configure().addAnnotatedClass(Inventory.class);
				SessionFactory sf = con.buildSessionFactory();
				Session session = sf.openSession(); 
				Transaction tx = session.beginTransaction();
				shoe.setshoes_retireShoe(1);
				session.update(shoe);
				tx.commit();
				inventoryDeleted(event);
				listAllShoes.clear();
				session.clear();
				session.close();
				sf.close();
				loadAllShoes();
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
	
	
	public void inventoryDeleted(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Shoe Deleted");
		alert.setHeaderText(null);
		alert.setContentText("A pair of Shoes were Deleted from the system.");

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
	
	
	public void selectShoe(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Shoe Not Selected");
		alert.setHeaderText(null);
		alert.setContentText("No Shoes has been selected from the list");

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
	private ListView<Inventory> listView;
	@FXML
	private TableView<Inventory> tableView;
	@FXML
	private TextField shoesize;
	@FXML
	private ObservableList<Inventory> listAllShoes = FXCollections.observableArrayList();
	
	
}

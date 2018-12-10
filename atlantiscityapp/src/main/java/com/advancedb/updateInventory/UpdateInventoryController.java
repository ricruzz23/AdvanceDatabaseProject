package com.advancedb.updateInventory;

/**
 * @author Padmaja
 * @Date 12/8/2018
 * @ This class controls the Inventory Update Screen
*/


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.advancedb.utilClasses.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UpdateInventoryController
{
	@FXML
	public void UpdateInventoryToDB(ActionEvent event) throws ClassNotFoundException, SQLException, ParseException 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Inventory.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = session.beginTransaction();

			updatedInventoryInfo = new Inventory();
			updatedInventoryInfo.setshoes_shoeID(inComingInventoryInfo.getshoes_shoeID());
			updatedInventoryInfo.setshoes_shoesgender(shoes_gender.getText());
			updatedInventoryInfo.setshoes_shoeSize(shoes_shoeSize.getText());
			updatedInventoryInfo.setshoes_shoeWidth(shoes_shoeWidth.getText());
			updatedInventoryInfo.setshoes_ageGroup(shoes_ageGroup.getText());
			updatedInventoryInfo.setshoes_isCheckedOut(inComingInventoryInfo.getisshoes_isCheckedOut());
			updatedInventoryInfo.setshoes_retireShoe(inComingInventoryInfo.getshoes_retireShoe());
			
		
		Inventory shoe2 = session.get(Inventory.class, inComingInventoryInfo.getshoes_shoeID());
		
		if(inComingInventoryInfo.equals(shoe2))
		{
			//Do nothing. Both inventory copies are identical no need to update record.
		}
		else
		{
			session.merge(updatedInventoryInfo);
		}
		
		tx.commit();
		session.clear();
		session.close();
		sf.close();
		
		updateSuccessfull(event);
	}

	@FXML
	public void exitUpdateInventoryScreen(ActionEvent e) 
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void setInfo(Inventory shoe) throws ClassNotFoundException
	{
		inComingInventoryInfo = shoe;
		shoes_shoeID.setText(shoe.getshoes_shoeID().toString());
		shoes_gender.setText(shoe.getshoes_shoesgender());
		shoes_shoeSize.setText(shoe.getshoes_shoeSize());
		shoes_shoeWidth.setText(shoe.getshoes_shoeWidth().toString());
		shoes_ageGroup.setText(shoe.getshoes_ageGroup());
	//	shoes_isCheckedOut.setText(shoe.getisshoes_isCheckedOut());
	}
	
	public void updateSuccessfull(ActionEvent e)
	{
		final Node source = (Node) e.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Update Successfull");
		alert.setHeaderText(null);
		alert.setContentText("The shoe's information has been updated");

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
	private TextField shoes_shoeID;
	@FXML
	private TextField shoes_gender;
	@FXML
	private TextField shoes_shoeSize;
	@FXML
	private TextField shoes_shoeWidth;
	@FXML
	private TextField shoes_ageGroup;
	@FXML
	private TextField shoes_isCheckedOut;
	
	private Inventory inComingInventoryInfo;
	private Inventory updatedInventoryInfo;
}
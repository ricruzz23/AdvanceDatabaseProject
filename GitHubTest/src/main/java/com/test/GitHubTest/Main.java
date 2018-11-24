package com.test.GitHubTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.GitHubTest.Alien;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		Alien cruz = new Alien();
        cruz.setAid(101);
        cruz.setAname("Cruz");
        cruz.setColor("Green");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);  
        
        
        SessionFactory factory = config.buildSessionFactory();
        
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(cruz);
        
        tx.commit();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

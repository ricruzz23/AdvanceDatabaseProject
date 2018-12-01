package com.advancedb.utilClasses;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


/**
 * @author Roger Cruz
 * @date 11/25/2018
 * 
 * This classes is used to store the customer's information coming from the DB.
 * 
 * */
@Entity
public class Customers 
{
	
	
	
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
	
	/**
	 * @return the customers_lastName
	 */
	public String getCustomers_lastName() {
		return customers_lastName;
	}
	/**
	 * @param customers_lastName the customers_lastName to set
	 */
	public void setCustomers_lastName(String customers_lastName) {
		this.customers_lastName = customers_lastName;
	}
	/**
	 * @return the customer_firstName
	 */
	public String getCustomer_firstName() {
		return customer_firstName;
	}
	/**
	 * @param customer_firstName the customer_firstName to set
	 */
	public void setCustomer_firstName(String customer_firstName) {
		this.customer_firstName = customer_firstName;
	}
	/**
	 * @return the customers_phoneNumber
	 */
	public int getCustomers_phoneNumber() {
		return customers_phoneNumber;
	}
	/**
	 * @param i the customers_phoneNumber to set
	 */
	public void setCustomers_phoneNumber(int i) {
		this.customers_phoneNumber = i;
	}
	/**
	 * @return the customers_Email
	 */
	public String getCustomers_Email() {
		return customers_Email;
	}
	/**
	 * @param customers_Email the customers_Email to set
	 */
	public void setCustomers_Email(String customers_Email) {
		this.customers_Email = customers_Email;
	}
	/**
	 * @return the customers_registrationDate
	 */
	public Date getCustomers_registrationDate() {
		return customers_registrationDate;
	}
	/**
	 * @param sqlDate the customers_registrationDate to set
	 */
	public void setCustomers_registrationDate(Date sqlDate) {
		this.customers_registrationDate = sqlDate;
	}
	/**
	 * @return the customers_deactive
	 */
	public boolean isCustomers_deactive() {
		return customers_deactive;
	}
	/**
	 * @param customers_deactive the customers_deactive to set
	 */
	public void setCustomers_deactive(boolean customers_deactive) {
		this.customers_deactive = customers_deactive;
	}
	/**
	 * @return the customers_deactiveDate
	 */
	public Date getCustomers_deactiveDate() {
		return customers_deactiveDate;
	}
	/**
	 * @param customers_deactiveDate the customers_deactiveDate to set
	 */
	public void setCustomers_deactiveDate(Date customers_deactiveDate) {
		this.customers_deactiveDate = customers_deactiveDate;
	}
	@Id
	private String customers_lastName;
	private String customer_firstName;
	private int customers_phoneNumber;
	private String customers_Email;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customers_registrationDate")
	private Date customers_registrationDate;
	private boolean customers_deactive;
	private Date customers_deactiveDate;
	
	
}

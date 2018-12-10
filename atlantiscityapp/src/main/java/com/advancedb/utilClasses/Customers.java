package com.advancedb.utilClasses;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


/**
 * @author Roger Cruz
 * @date 11/25/2018
 * 
 * This classes is used to store the customer's information coming from the DB.
 * 
 * */
@Entity(name="customers")
public class Customers 
{
	
	/**
	 * @return the customers_customerID
	 */
	public Integer getCustomers_customerID() {
		return customers_customerID;
	}
	/**
	 * @param customers_customerID the customers_customerID to set
	 */
	public void setCustomers_customerID(Integer customers_customerID) {
		this.customers_customerID = customers_customerID;
	}
	/**
	 * @return the customers_lastName
	 */
	public String getCustomers_lastName() {
		
		if(customers_lastName.equals(null) || customers_lastName.equals(""))
		{
			customers_lastName = "N/A";
		}

		return customers_lastName;
	}
	/**
	 * @param customers_lastName the customers_lastName to set
	 */
	public void setCustomers_lastName(String customers_lastName) {
		
		if(customers_lastName.equals(null) || customers_lastName.equals(""))
		{
			customers_lastName = "N/A";
			this.customers_lastName = customers_lastName;
		}
		else
		{
			this.customers_lastName = customers_lastName;
		}

	}
	/**
	 * @return the customer_firstName
	 */
	public String getCustomer_firstName() {
		
		if(customer_firstName.equals(null) || customer_firstName.equals(""))
		{
			customer_firstName = "N/A";
		}
		
		return customer_firstName;
	}
	/**
	 * @param customer_firstName the customer_firstName to set
	 */
	public void setCustomer_firstName(String customer_firstName) {
		
		if(customer_firstName.equals(null) || customer_firstName.equals(""))
		{
			customer_firstName = "N/A";
			this.customer_firstName = customer_firstName;
		}
		else
		{
			this.customer_firstName = customer_firstName;
		}
	}
	/**
	 * @return the customers_phoneNumber
	 */
	public Long getCustomers_phoneNumber() {
		
		if(customers_phoneNumber.equals(null))
		{
			customers_phoneNumber = (long) 0;
		}
		return customers_phoneNumber;
	}
	/**
	 * @param long1 the customers_phoneNumber to set
	 */
	public void setCustomers_phoneNumber(Long long1) {
		
		if(long1.equals(null))
		{
			long1 = (long) 0;
			this.customers_phoneNumber = long1;
		}
		else
		{
			this.customers_phoneNumber = long1;
		}
		
		
	}
	/**
	 * @return the customers_email
	 */
	public String getCustomers_email() {
		return customers_email;
	}
	/**
	 * @param customers_Email the customers_Email to set
	 */
	public void setCustomers_email(String customers_email) {
		
		if(customers_email.equals(null) || customers_email.equals(""))
		{
			customers_email = "N/A";
			this.customers_email = customers_email;
		}
		else
		{
			this.customers_email = customers_email;
		}

	}
	/**
	 * @return the customers_registrationDate
	 */
	public LocalDate getCustomers_registrationDate() {
		
		return customers_registrationDate;
	}
	/**
	 * @param sqlDate the customers_registrationDate to set
	 */
	public void setCustomers_registrationDate(LocalDate sqlDate) {
		if(sqlDate.equals(null))
		{
			sqlDate = LocalDate.now();
			this.customers_registrationDate = sqlDate;
		}
		else
		{
			this.customers_registrationDate = sqlDate;
		}
		
	}
	/**
	 * @return the customers_deactive
	 */
	public Integer getCustomers_deactive() {
		
		if(customers_deactive == null)
		{
			customers_deactive = 0;
		}
		
		return customers_deactive;
	}
	/**
	 * @param customers_deactive the customers_deactive to set
	 */
	public void setCustomers_deactive(Integer customers_deactive) {
		
		if(customers_deactive == null)
		{
			customers_deactive = 0;
			this.customers_deactive = customers_deactive;
		}
		else
		{
			this.customers_deactive = customers_deactive;
		}
		
	}
	/**
	 * @return the customers_deactiveDate
	 */
	public LocalDate getCustomers_deactiveDate() {
		
		if(customers_deactiveDate == null)
		{
			customers_deactiveDate = LocalDate.now();
		}
		
		return customers_deactiveDate;
	}
	/**
	 * @param customers_deactiveDate the customers_deactiveDate to set
	 */
	public void setCustomers_deactiveDate(LocalDate customers_deactiveDate) 
	{
		if(customers_deactiveDate == null)
		{
			customers_deactiveDate = LocalDate.now();
		}
		
			this.customers_deactiveDate = customers_deactiveDate;
	}
	
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customers_customerID")
	private Integer customers_customerID;
	@Column(name="customers_lastName")
	private String customers_lastName;
	@Column(name="customer_firstName")
	private String customer_firstName;
	@Column(name="customers_phoneNumber")
	private Long customers_phoneNumber;
	@Column(name="customers_email")
	private String customers_email;
	@CreationTimestamp
	@Column(name = "customers_registrationDate")
	private LocalDate customers_registrationDate;
	@Column(name="customers_deactive")
	private Integer customers_deactive = 0;
	@Column(name="customers_deactiveDate")
	private LocalDate customers_deactiveDate;
	
	
	public void throwException() throws Exception {
        throw new Exception("Uh oh, this is an Exception message!");
    }
	
}
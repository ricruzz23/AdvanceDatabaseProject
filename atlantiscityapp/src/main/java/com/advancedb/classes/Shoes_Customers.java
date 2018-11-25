
package com.advancedb.classes;

import java.sql.Date;

/**
 * @author Padmaja
 * @date 11/25/2018
 * 
 * This classes is used to store the shoes_customer's information coming from the DB.
 */
public class Shoes_Customers {
	
	/*-------------------------------------------------------------
	 * Getter and Setter Methods for the Class
	 * ------------------------------------------------------------*/
	
	private int intSC_ShoesCustomersID;
	/**
	 * @return the intSC_ShoesCustomersID
	 */
	public int getIntSC_ShoesCustomersID() {
		return intSC_ShoesCustomersID;
	}
	/**
	 * @param intSC_ShoesCustomersID the intSC_ShoesCustomersID to set
	 */
	public void setIntSC_ShoesCustomersID(int intSC_ShoesCustomersID) {
		this.intSC_ShoesCustomersID = intSC_ShoesCustomersID;
	}
	/**
	 * @return the intSC_CustomerID
	 */
	public int getIntSC_CustomerID() {
		return intSC_CustomerID;
	}
	/**
	 * @param intSC_CustomerID the intSC_CustomerID to set
	 */
	public void setIntSC_CustomerID(int intSC_CustomerID) {
		this.intSC_CustomerID = intSC_CustomerID;
	}
	/**
	 * @return the intSC_ShoeID
	 */
	public int getIntSC_ShoeID() {
		return intSC_ShoeID;
	}
	/**
	 * @param intSC_ShoeID the intSC_ShoeID to set
	 */
	public void setIntSC_ShoeID(int intSC_ShoeID) {
		this.intSC_ShoeID = intSC_ShoeID;
	}
	/**
	 * @return the dateCheckedoutdate
	 */
	public Date getDateCheckedoutdate() {
		return dateCheckedoutdate;
	}
	/**
	 * @param dateCheckedoutdate the dateCheckedoutdate to set
	 */
	public void setDateCheckedoutdate(Date dateCheckedoutdate) {
		this.dateCheckedoutdate = dateCheckedoutdate;
	}
	/**
	 * @return the dateCheckindate
	 */
	public Date getDateCheckindate() {
		return dateCheckindate;
	}
	/**
	 * @param dateCheckindate the dateCheckindate to set
	 */
	public void setDateCheckindate(Date dateCheckindate) {
		this.dateCheckindate = dateCheckindate;
	}
	
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
	
	private int intSC_CustomerID;
	private int intSC_ShoeID;
	private Date dateCheckedoutdate;
	private Date dateCheckindate;
	
}

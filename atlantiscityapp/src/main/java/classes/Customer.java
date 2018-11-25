package classes;

import java.sql.Date;

/**
 * @author Roger Cruz
 * @date 11/25/2018
 * 
 * This classes is used to store the customer's information coming from the DB.
 * 
 * */

public class Customer 
{
	
	/*-------------------------------------------------------------
	 * Getter and Setter Methods for the Class
	 * ------------------------------------------------------------*/
	
	/**
	 * @return the strCustomerLastName
	 */
	public String getStrCustomerLastName() {
		return strCustomerLastName;
	}
	/**
	 * @param strCustomerLastName the strCustomerLastName to set
	 */
	public void setStrCustomerLastName(String strCustomerLastName) {
		this.strCustomerLastName = strCustomerLastName;
	}
	/**
	 * @return the strCustomerFirstName
	 */
	public String getStrCustomerFirstName() {
		return strCustomerFirstName;
	}
	/**
	 * @param strCustomerFirstName the strCustomerFirstName to set
	 */
	public void setStrCustomerFirstName(String strCustomerFirstName) {
		this.strCustomerFirstName = strCustomerFirstName;
	}
	/**
	 * @return the lngPhoneNumber
	 */
	public Long getLngPhoneNumber() {
		return lngPhoneNumber;
	}
	/**
	 * @param lngPhoneNumber the lngPhoneNumber to set
	 */
	public void setLngPhoneNumber(Long lngPhoneNumber) {
		this.lngPhoneNumber = lngPhoneNumber;
	}
	/**
	 * @return the strCustomerEmail
	 */
	public String getStrCustomerEmail() {
		return strCustomerEmail;
	}
	/**
	 * @param strCustomerEmail the strCustomerEmail to set
	 */
	public void setStrCustomerEmail(String strCustomerEmail) {
		this.strCustomerEmail = strCustomerEmail;
	}
	/**
	 * @return the dtRegistrationDate
	 */
	public Date getDtRegistrationDate() {
		return dtRegistrationDate;
	}
	/**
	 * @param dtRegistrationDate the dtRegistrationDate to set
	 */
	public void setDtRegistrationDate(Date dtRegistrationDate) {
		this.dtRegistrationDate = dtRegistrationDate;
	}
	/**
	 * @return the boolDeactivate
	 */
	public boolean isBoolDeactivate() {
		return boolDeactivate;
	}
	/**
	 * @param boolDeactivate the boolDeactivate to set
	 */
	public void setBoolDeactivate(boolean boolDeactivate) {
		this.boolDeactivate = boolDeactivate;
	}
	/**
	 * @return the dtDeactivateDate
	 */
	public Date getDtDeactivateDate() {
		return dtDeactivateDate;
	}
	/**
	 * @param dtDeactivateDate the dtDeactivateDate to set
	 */
	public void setDtDeactivateDate(Date dtDeactivateDate) {
		this.dtDeactivateDate = dtDeactivateDate;
	}
	
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
	
	private String strCustomerLastName;
	private String strCustomerFirstName;
	private Long lngPhoneNumber;
	private String strCustomerEmail;
	private Date dtRegistrationDate;
	private boolean boolDeactivate;
	private Date dtDeactivateDate;
	
	
}

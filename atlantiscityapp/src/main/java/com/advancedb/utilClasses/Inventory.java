
package com.advancedb.utilClasses;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 * @author Padmaja
 * @Date 11/25/2018
 *
 *This classes is used to store the shoe's information coming from the DB.
 */

@Entity(name="shoes")

public class Inventory {
	
	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/	
	
	
	/**
	 * @return the shoes_shoesgender
	 */
	public String getshoes_shoesgender() {
		return shoes_shoesgender;
	}


	/**
	 * @param shoes_shoesgender the shoes_shoesgender to set
	 */
	public void setshoes_shoesgender(String shoes_shoesgender) {
		this.shoes_shoesgender = shoes_shoesgender;
	}


	/**
	 * @return the shoes_shoeSize
	 */
	public String getshoes_shoeSize() {
		return shoes_shoeSize;
	}


	/**
	 * @param shoes_shoeSize the shoes_shoeSize to set
	 */
	public void setshoes_shoeSize(String shoes_shoeSize) {
		this.shoes_shoeSize = shoes_shoeSize;
	}


	/**
	 * @return the shoes_shoeWidth
	 */
	public String getshoes_shoeWidth() {
		return shoes_shoeWidth;
	}


	/**
	 * @param shoes_shoeWidth the shoes_shoeWidth to set
	 */
	public void setshoes_shoeWidth(String shoes_shoeWidth) {
		this.shoes_shoeWidth = shoes_shoeWidth;
	}


	/**
	 * @return the shoes_ageGroup
	 */
	public String getshoes_ageGroup() {
		return shoes_ageGroup;
	}


	/**
	 * @param shoes_ageGroup the shoes_ageGroup to set
	 */
	public void setshoes_ageGroup(String shoes_ageGroup) {
		this.shoes_ageGroup = shoes_ageGroup;
	}


	/**
	 * @return the shoes_isCheckedOut
	 */
	public boolean isshoes_isCheckedOut() {
		return shoes_isCheckedOut;
	}


	/**
	 * @param shoes_isCheckedOut the shoes_isCheckedOut to set
	 */
	public void setshoes_isCheckedOut(boolean shoes_isCheckedOut) {
		this.shoes_isCheckedOut = shoes_isCheckedOut;
	}


	/**
	 * @return the shoes_retireShoe
	 */
	public boolean isshoes_retireShoe() {
		return shoes_retireShoe;
	}


	/**
	 * @param shoes_retireShoe the shoes_retireShoe to set
	 */
	public void setshoes_retireShoe(boolean shoes_retireShoe) {
		this.shoes_retireShoe = shoes_retireShoe;
	}

	@Id
	@Column(name="shoes_shoeID")
	private int customers_customerID;
	
	@Column(name="shoes_shoesgender")	
	private String shoes_shoesgender;
	
	@Column(name="shoes_shoeSize")
	private String shoes_shoeSize;
	
	@Column(name="shoes_shoeWidth")
	private String shoes_shoeWidth;
	
	@Column(name="shoes_ageGroup")
	private String shoes_ageGroup;
	
	@Column(name="shoes_isCheckedOut")	
	private boolean shoes_isCheckedOut;
	
	@Column(name="shoes_retireShoe")
	private boolean shoes_retireShoe;
}

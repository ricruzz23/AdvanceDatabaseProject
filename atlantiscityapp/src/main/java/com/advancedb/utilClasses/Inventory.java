
package com.advancedb.utilClasses;

import java.sql.Date;

/**
 * @author Padmaja
 * @Date 11/25/2018
 *
 */
public class Inventory {
	
	/**
	 * @return the charShoesGender
	 */
	public String getCharShoesGender() {
		return charShoesGender;
	}


	/**
	 * @param charShoesGender the charShoesGender to set
	 */
	public void setCharShoesGender(String charShoesGender) {
		this.charShoesGender = charShoesGender;
	}


	/**
	 * @return the dbShoesShoesize
	 */
	public String getDbShoesShoesize() {
		return dbShoesShoesize;
	}


	/**
	 * @param dbShoesShoesize the dbShoesShoesize to set
	 */
	public void setDbShoesShoesize(String dbShoesShoesize) {
		this.dbShoesShoesize = dbShoesShoesize;
	}


	/**
	 * @return the charShoesShoewidth
	 */
	public String getCharShoesShoewidth() {
		return charShoesShoewidth;
	}


	/**
	 * @param charShoesShoewidth the charShoesShoewidth to set
	 */
	public void setCharShoesShoewidth(String charShoesShoewidth) {
		this.charShoesShoewidth = charShoesShoewidth;
	}


	/**
	 * @return the charShoesAgegroup
	 */
	public String getCharShoesAgegroup() {
		return charShoesAgegroup;
	}


	/**
	 * @param charShoesAgegroup the charShoesAgegroup to set
	 */
	public void setCharShoesAgegroup(String charShoesAgegroup) {
		this.charShoesAgegroup = charShoesAgegroup;
	}


	/**
	 * @return the boolShoesIscheckedout
	 */
	public boolean isBoolShoesIscheckedout() {
		return boolShoesIscheckedout;
	}


	/**
	 * @param boolShoesIscheckedout the boolShoesIscheckedout to set
	 */
	public void setBoolShoesIscheckedout(boolean boolShoesIscheckedout) {
		this.boolShoesIscheckedout = boolShoesIscheckedout;
	}


	/**
	 * @return the boolShoesRetireshoe
	 */
	public boolean isBoolShoesRetireshoe() {
		return boolShoesRetireshoe;
	}


	/**
	 * @param boolShoesRetireshoe the boolShoesRetireshoe to set
	 */
	public void setBoolShoesRetireshoe(boolean boolShoesRetireshoe) {
		this.boolShoesRetireshoe = boolShoesRetireshoe;
	}


	/*-------------------------------------------------------------
	 * Data Members for the class
	 * ------------------------------------------------------------*/
	
	private String charShoesGender;
	private String dbShoesShoesize;
	private String charShoesShoewidth;
	private String charShoesAgegroup;
	private boolean boolShoesIscheckedout;
	private boolean boolShoesRetireshoe;
}

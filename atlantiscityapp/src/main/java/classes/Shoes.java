package classes;

import java.sql.Date;

/**
 * @author Padmaja
 * @Date 11/25/2018
 * * 
 * This classes is used to store the shoe's information coming from the DB.
 * 
 */
public class Shoes {
	
	/*-------------------------------------------------------------
	 * Getter and Setter Methods for the Class
	 * ------------------------------------------------------------*/
	
	
	/**
	 * @return the charShoesGender
	 */
	public char getCharShoesGender() {
		return charShoesGender;
	}


	/**
	 * @param charShoesGender the charShoesGender to set
	 */
	public void setCharShoesGender(char charShoesGender) {
		this.charShoesGender = charShoesGender;
	}


	/**
	 * @return the dbShoesShoesize
	 */
	public double getDbShoesShoesize() {
		return dbShoesShoesize;
	}


	/**
	 * @param dbShoesShoesize the dbShoesShoesize to set
	 */
	public void setDbShoesShoesize(double dbShoesShoesize) {
		this.dbShoesShoesize = dbShoesShoesize;
	}


	/**
	 * @return the charShoesShoewidth
	 */
	public char getCharShoesShoewidth() {
		return charShoesShoewidth;
	}


	/**
	 * @param charShoesShoewidth the charShoesShoewidth to set
	 */
	public void setCharShoesShoewidth(char charShoesShoewidth) {
		this.charShoesShoewidth = charShoesShoewidth;
	}


	/**
	 * @return the charShoesAgegroup
	 */
	public char getCharShoesAgegroup() {
		return charShoesAgegroup;
	}


	/**
	 * @param charShoesAgegroup the charShoesAgegroup to set
	 */
	public void setCharShoesAgegroup(char charShoesAgegroup) {
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
	
	private int intShoes_ShoeID;
	private char charShoesGender;
	private double dbShoesShoesize;
	private char charShoesShoewidth;
	private char charShoesAgegroup;
	private boolean boolShoesIscheckedout;
	private boolean boolShoesRetireshoe;
}

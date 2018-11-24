package com.test.GitHubTest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien
{
	@Id
	private int aid;
	private String aname;
	private String color;
	/**
	 * @return the aid
	 */
	public int getAid()
	{
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid)
	{
		this.aid = aid;
	}
	/**
	 * @return the aname
	 */
	public String getAname()
	{
		return aname;
	}
	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname)
	{
		this.aname = aname;
	}
	/**
	 * @return the color
	 */
	public String getColor()
	{
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color)
	{
		this.color = color;
	}
	
	
}

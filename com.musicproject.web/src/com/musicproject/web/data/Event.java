package com.musicproject.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {
	
	private Integer id;
	private String name;
	private String area;
	private String date;
	private int artist_id;
	
	public Event(String name, String area, String date, int artist_id, int id) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.date = date;
		this.artist_id = artist_id;
	}
	
	public Event(String name, String area, String date, int artist_id) {
		super();
		this.id = null;
		this.name = name;
		this.area = area;
		this.date = date;
		this.artist_id = artist_id;
	}
	
	public Event() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}

	@Override
	public String toString() {
		return " id-> " + id + ", name -> " + name + ", area -> " + area + ", date -> " + date + ", artist_id -> " + artist_id;
	}
	
	

}

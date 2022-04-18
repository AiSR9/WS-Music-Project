package com.musicproject.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artist {
	
	private Integer id;
	private String name;
	private String nationality;
	
	public Artist(String name, String nationality, int id) {
		super();
		this.id = id;
		this.name = name;
		this.nationality = nationality;
	}
	
	public Artist(String name, String nationality) {
		super();
		this.id =  null;
		this.name = name;
		this.nationality = nationality;
	}
	
	public Artist() {}

	public Integer getId() {
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return " Id -> " + id + ", name -> " + name + ", nationality -> " + nationality;
	}
	
}

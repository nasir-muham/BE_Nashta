package com.example.nashta_test.dtos;

import java.util.Date;

public class DataDto {
	private long id;
	private String title;
	private String location;
	private Date date;
	private String note;
	private String image;
	private String participant;
	public DataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataDto(long id, String title, String location, Date date, String note, String image, String participant) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.date = date;
		this.note = note;
		this.image = image;
		this.participant = participant;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	
	
}

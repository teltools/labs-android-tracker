package com.tracking.model;

public class Tracked {
	
	protected int id_user;
	protected int id_tracked;
	protected String name;
	protected int time;
	
	
	public Tracked(int id_user, int id_tracked, String name, int time) {
		super();
		this.id_user = id_user;
		this.id_tracked = id_tracked;
		this.name = name;
		this.time = time;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_tracked() {
		return id_tracked;
	}

	public void setId_tracked(int id_tracked) {
		this.id_tracked = id_tracked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}

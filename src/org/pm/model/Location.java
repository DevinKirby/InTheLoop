package org.pm.model;
public class Location {
	private String name;
	private String address;
	private String id;
	private double lat;
	private double lng;
	private String openStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String formatted_address) {
		this.address = formatted_address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String isOpen) {
		this.openStatus = isOpen;
	}
}

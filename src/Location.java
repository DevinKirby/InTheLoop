public class Location {
	private String name;
	private String address;
	private String place_id;
	private double lat;
	private double lng;

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
	public String getPlaceId() {
		return place_id;
	}
	public void setPlaceId(String id) {
		this.place_id = id;
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
}

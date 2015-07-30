
import java.io.Serializable;

public class DummyBean implements Serializable {
	
	private String stationID = "";
	private String pointOfInterest = "";
	
	public DummyBean() {
		
	}
	
	public DummyBean(String stationID, String pointOfInterest) {
		this.stationID = stationID;
		this.pointOfInterest = pointOfInterest;
	}
	
	public String getStationID() {
		return stationID;
	}
	
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	
	public String getPointOfInterest() {
		return pointOfInterest;
	}
	
	public void setPointOfInterest(String pointOfInterest) {
		this.pointOfInterest = pointOfInterest;
	}
	
}

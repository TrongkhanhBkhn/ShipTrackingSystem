package vn.com.daisy.shiptrackingsystem.main;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "geocodeView")
public class GeocodeView {

	private MapModel geoModel;
	private MapModel revGeoModel;
	private String centerGeoMap = "16.419067, 107.587207";
	private String centerRevGeoMap = "16.419067, 107.587207";
	private String type;

	@PostConstruct
	public void init() {
		geoModel = new DefaultMapModel();
		revGeoModel = new DefaultMapModel();
		type = "ROADMAP";

	}

	public void onGeocode(GeocodeEvent event) {
		List<GeocodeResult> results = event.getResults();

		if (results != null && !results.isEmpty()) {
			LatLng center = results.get(0).getLatLng();
			centerGeoMap = center.getLat() + "," + center.getLng();

			for (int i = 0; i < results.size(); i++) {
				GeocodeResult result = results.get(i);
				geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
			}
		}
	}

	public void onReverseGeocode(ReverseGeocodeEvent event) {
		List<String> addresses = event.getAddresses();
		LatLng coord = event.getLatlng();

		if (addresses != null && !addresses.isEmpty()) {
			centerRevGeoMap = coord.getLat() + "," + coord.getLng();
			revGeoModel.addOverlay(new Marker(coord, addresses.get(0)));
		}
	}

	public void change() {
		this.setType("HYBRID");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MapModel getGeoModel() {
		return geoModel;
	}

	public MapModel getRevGeoModel() {
		return revGeoModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public String getCenterRevGeoMap() {
		return centerRevGeoMap;
	}
}
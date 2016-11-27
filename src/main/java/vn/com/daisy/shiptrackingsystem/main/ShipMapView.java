package vn.com.daisy.shiptrackingsystem.main;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

@ManagedBean(name = "shipMapView")
@ViewScoped
public class ShipMapView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapModel shipModel;
	private String centerGeoMap = "16.419067, 107.587207";
	private String centerRevGeoMap = "16.419067, 107.587207";
	private List<Marker> markers;
	private List<Polyline> polylines;
	private ShipInfor shipInfor;
	private Marker marker;

	@PostConstruct
	public void init() {
		shipModel = new DefaultMapModel();
		Initation();
	}

	public void Initation() {
		shipInfor = new ShipInfor();
		markers = shipInfor.getMaker();
		polylines = shipInfor.getPolyline();
		for (Marker marker : markers) {
			shipModel.addOverlay(marker);
		}
		for (Polyline p : polylines) {
			shipModel.addOverlay(p);
		}
		System.out.println("Init");
	}

	public MapModel getShipModel() {
		return shipModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public String getCenterRevGeoMap() {
		return centerRevGeoMap;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

}
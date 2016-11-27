package vn.com.daisy.shiptrackingsystem.main;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import vn.com.daisy.shiptrackingsystem.dao.Ship;
import vn.com.daisy.shiptrackingsystem.dao.ShipDAO;
import vn.com.daisy.shiptrackingsystem.dao.ShipTrackingDAO;
import vn.com.daisy.shiptrackingsystem.dao.Shiptracking;

public class ShipInfor {
	private List<Ship> ships;
	private List<Shiptracking> ships_;

	public ShipInfor() {
		ShipDAO dao = new ShipDAO();
		ShipTrackingDAO stDao = new ShipTrackingDAO();
		ships = dao.getAllShips();
		ships_ = stDao.getAllShips();
	}

	public List<Marker> getMaker() {
		List<Marker> list = new ArrayList<Marker>();
		Marker marker = null;
		for (Ship ship : ships) {
			marker = new Marker(new LatLng(ship.getLat(), ship.getLong_()),
					ship.getName(), ship.getImage(),
					"http://maps.google.com/mapfiles/ms/micons/blue-dot.png");
			list.add(marker);
		}
		return list;
	}

	public List<Polyline> getPolyline() {
		List<Polyline> list = new ArrayList<>();
		Polyline p;
		p = new Polyline();
		for (Shiptracking ship : ships_) {
			p.getPaths().add(new LatLng(ship.getLat(), ship.getLong_()));

		}
		p.setStrokeWeight(10);
		p.setStrokeColor("EF1FFF");
		p.setStrokeOpacity(0.7);
		list.add(p);
		return list;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

}

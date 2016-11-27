package vn.com.daisy.shiptrackingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShipDAO {
	@SuppressWarnings("unchecked")
	public List<Ship> getAllShips() {
		List<Ship> list = new ArrayList<>();
		Transaction trns = null;
		Session session = null;
		session = HibernateUtil.openSession();
		String querySQL = "FROM Ship";
		try {
			trns = session.beginTransaction();
			Query query = session.createQuery(querySQL);
			list = (List<Ship>) query.list();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		if (list.toString() == "[]") {
			return null;
		}
		return list;
	}

}

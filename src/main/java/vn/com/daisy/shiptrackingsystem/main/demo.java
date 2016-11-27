package vn.com.daisy.shiptrackingsystem.main;

import javax.faces.context.FacesContext;

import org.hibernate.Hibernate;

import vn.com.daisy.shiptrackingsystem.dao.*;

public class demo {

	public static void main(String[] args) {
		String relativePath="/resources/images/";
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(context.getCurrentInstance().getClass());
	}

}

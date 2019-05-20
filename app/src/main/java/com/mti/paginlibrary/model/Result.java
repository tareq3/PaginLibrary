package com.mti.paginlibrary.model;

import java.util.List;

public class Result{
	private List<Outlet> outlet;

	public void setOutlet(List<Outlet> outlet){
		this.outlet = outlet;
	}

	public List<Outlet> getOutlet(){
		return outlet;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"outlet = '" + outlet + '\'' + 
			"}";
		}
}
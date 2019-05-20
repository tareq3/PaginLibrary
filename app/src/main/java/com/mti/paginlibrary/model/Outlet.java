package com.mti.paginlibrary.model;

public class Outlet {
	private String owner;
	private String address;
	private Object latitude;
	private String type;
	private Object thana;
	private String phone;
	private String creditBalance;
	private Object district;
	private Object xtr;
	private String name;
	private String creditLimit;
	private String xgcus;
	private String id;
	private Object longitude;

	public void setOwner(String owner){
		this.owner = owner;
	}

	public String getOwner(){
		return owner;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}

	public Object getLatitude(){
		return latitude;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setThana(Object thana){
		this.thana = thana;
	}

	public Object getThana(){
		return thana;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setCreditBalance(String creditBalance){
		this.creditBalance = creditBalance;
	}

	public String getCreditBalance(){
		return creditBalance;
	}

	public void setDistrict(Object district){
		this.district = district;
	}

	public Object getDistrict(){
		return district;
	}

	public void setXtr(Object xtr){
		this.xtr = xtr;
	}

	public Object getXtr(){
		return xtr;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreditLimit(String creditLimit){
		this.creditLimit = creditLimit;
	}

	public String getCreditLimit(){
		return creditLimit;
	}

	public void setXgcus(String xgcus){
		this.xgcus = xgcus;
	}

	public String getXgcus(){
		return xgcus;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLongitude(Object longitude){
		this.longitude = longitude;
	}

	public Object getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Outlet{" +
			"owner = '" + owner + '\'' + 
			",address = '" + address + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",type = '" + type + '\'' + 
			",thana = '" + thana + '\'' + 
			",phone = '" + phone + '\'' + 
			",credit_balance = '" + creditBalance + '\'' + 
			",district = '" + district + '\'' + 
			",xtr = '" + xtr + '\'' + 
			",name = '" + name + '\'' + 
			",credit_limit = '" + creditLimit + '\'' + 
			",xgcus = '" + xgcus + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}

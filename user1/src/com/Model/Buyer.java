package com.n.User.Model;


public class Buyer {
	
	private int id;
	private int buyer_id;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getBuyer_id() {
		return buyer_id;
	}



	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}



	@Override
	public String toString() {
		return "Buyer[id=" + id+ ",buyer_id="+buyer_id +"]";
	}

}

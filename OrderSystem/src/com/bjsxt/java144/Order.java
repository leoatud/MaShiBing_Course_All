package com.bjsxt.java144;





public class Order {
	
	private String productName = null;
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	private int count = 0;
	private int unitPrice = 0;
	
	public int getTotalPrice() {
		return count *unitPrice;
	}
	
	public String toString() {
		return productName + "-" + getTotalPrice();
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order o = new Order();
		o.setProductName("beta");
		o.setCount(10);;
		o.setUnitPrice(12);
		System.out.println(o);
	}

}

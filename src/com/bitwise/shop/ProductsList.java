package com.bitwise.shop;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.shop.Product;

public class ProductsList {
	List<Product> myList = new ArrayList<Product>();
	List<Product> myList3 = new ArrayList<Product>();// blank new list\
	public List<Product> getMyList3() {
		return myList3;
	}
	public void setMyList3(List<Product> myList3) {
		this.myList3 = myList3;
	}
	public ProductsList() {
		this.addToMyList();
	}
	public List<Product> getMyList() {
		return myList;
	}

	public void setMyList(List<Product> myList) {
		this.myList = myList;
	}

	private void addToMyList() {
		// TODO Auto-generated method stub
	}
	public Product getProduct(String name){
		for(Product p:myList){
			if(p.pname.equals(name)){
				return p;
			}
		} return null;
		
	
	}

}

package com.bitwise.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	int cartSize;
	double cartPrice;
	List<Product> myCartList = new ArrayList<Product>();
	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize ;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public List<Product> getMyCartList() {
		return myCartList;
	}
	
	public void setMyCartList(List<Product> myCartList) {
		this.myCartList = myCartList;
	}
	private boolean inStock(Product prod) {
        if (prod.getStock()- 1 < 0)
              return false;
        return true;
  }

	public void addToMyCart(Product product){
			
			if(inStock(product))
			{
				cartPrice += Integer.parseInt(product.getPrice());
				product.setStock(product.getStock() - 1);
				myCartList.add(product);
				//System.out.println(	myCartList.size());
			} 
			else
			{
                throw new OutOfStockException("Product out of stock");
			}

        }
    public void removeFromMyCart(Product product) {
    	
    	cartPrice -= Integer.parseInt(product.getPrice());
        product.setStock(product.getStock() + 1);
        myCartList.remove(product);
    	
        
    	}

	}
	
	



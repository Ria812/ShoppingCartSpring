package com.bitwise.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	
	@Autowired
	ProductsList productslist;
	@Autowired
	Product product;
	@Autowired
	ShoppingCart shoppingCart;
	
	
	 
	 @RequestMapping(value = "/app/Success",method = RequestMethod.GET)
	    public String initproduct(Model model) {
			//System.out.println("inside success get");
	        model.addAttribute("msg1", "Select from the list of products:");
	        List<Product> myList1 = productslist.getMyList();
	        model.addAttribute("myList1", myList1);
	        model.addAttribute("selecteditems", new ProductsSelected());
	        return "Success";
	    }
	 @RequestMapping( value ="/app/Success",method = RequestMethod.POST)
		public String selectedProductsubmit(Model model, @ModelAttribute("selecteditems") ProductsSelected productsSelected) {		
			String[] str1=  productsSelected.getUserList();//array of selected names 
			List<Product> myList2 = productslist.getMyList();// list of products from myList
			//System.out.println("inside success post");
	
			for(Product p:myList2 ){
				for(int i=0; i<str1.length;i++){
					if(p.getPname().equals(str1[i]))
					{
						productslist.myList3.add(p);
					}
				}
			}
			model.addAttribute("list", productslist.myList3);
			 return "SelectedProducts";
			}
	 
	 @RequestMapping(value="/app/additem", method = RequestMethod.POST)
	    public ModelAndView addProduct(@RequestParam ("addeditem")String prodname,Model model) {
		 //System.out.println(prodname);
		 shoppingCart.addToMyCart(productslist.getProduct(prodname));
	       return new ModelAndView("SelectedProducts", "list",productslist.getMyList3());
	   }
	 @RequestMapping(value="/app/viewmycart", method = RequestMethod.POST)
	    public ModelAndView viewProducts() {
	       return new ModelAndView("ViewCart", "cartlist",shoppingCart.getMyCartList());
	   }
	 
	 @RequestMapping(value="/app/removeitem", method = RequestMethod.POST)
	    public ModelAndView removeProduct(@RequestParam ("removeditem")String prodname,Model model) {
		 shoppingCart.removeFromMyCart(productslist.getProduct(prodname));
		 return new ModelAndView("ViewCart", "cartlist",shoppingCart.getMyCartList());
	   }
	 @RequestMapping(value="/app/myorder", method = RequestMethod.POST)
	    public ModelAndView viewOrder(Model model) {
		 model.addAttribute("totalprice",shoppingCart.getCartPrice());
	       return new ModelAndView("Order", "orderlist",shoppingCart.getMyCartList());
	   }
	 @ExceptionHandler(OutOfStockException.class)
	    public ModelAndView handleCustomException(OutOfStockException msg) {

	          return new ModelAndView("exception", "exceptionMsg", msg.getMessage());

	    }

}

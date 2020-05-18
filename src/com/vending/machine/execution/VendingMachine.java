package com.vending.machine.execution;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vending.machine.exception.ProductNotAvailableException;
import com.vending.machine.model.Product;
import com.vending.machine.model.SparkCoin;
import com.vending.machine.util.ProdcutDetails;
import com.vending.machine.util.SparkCoinInventory;

public class VendingMachine {

	ProdcutDetails prodcutDetails;
	SparkCoinInventory coinInventory;
	
	public VendingMachine() {
		super();
		this.prodcutDetails = new ProdcutDetails();
		this.coinInventory = new SparkCoinInventory();
	}


	
	
	public VendingMachine(ProdcutDetails prodcutDetails, SparkCoinInventory coinInventory) {
		super();
		this.prodcutDetails = prodcutDetails;
		this.coinInventory = coinInventory;
	}
	
	public boolean addProduct(Product product , Integer quantity)
	{
		return prodcutDetails.AddProduct(product, quantity);
	}


	public Product getProduct(int id , Map <SparkCoin,Integer> sparkCoins) throws ProductNotAvailableException
	{
		
		Product product= new Product();
		product.setId(id);
		
		if(prodcutDetails.checkProductAvaibility(product))
		{		
			Product productInfo = prodcutDetails.getProductDetialFromProductCatalog(id);
		    int productSparkValue = productInfo.getSparkValue();
		    int userAddedSparkCoin= 0;
		    Set<SparkCoin> list =sparkCoins.keySet();
		    for(SparkCoin sc:list)
		    {
		    	int value= sc.getValue() * sparkCoins.get(sc);
		    	userAddedSparkCoin =userAddedSparkCoin+ value;
		    }
		    
		    if(productSparkValue <= userAddedSparkCoin)
		    {
		    	return prodcutDetails.getProduct(product);
		    }
		    
		    throw new ProductNotAvailableException("User enter spark coin value are less than prodcut sprk value");
		    
		}
		
		
		return null;
	}
	
	public Integer  getRemainingProduct(int id) throws ProductNotAvailableException
	{
		return prodcutDetails.getremainingProduct(id);
		
	}
	
	
}

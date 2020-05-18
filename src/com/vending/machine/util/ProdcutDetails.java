package com.vending.machine.util;

import java.util.HashMap;
import java.util.Map;

import com.vending.machine.exception.ProductNotAvailableException;
import com.vending.machine.model.Product;

public class ProdcutDetails {
	
	Map<Product ,Integer> inventory = new HashMap<>();
	Map<Integer ,Product> prodcuctCatalog = new HashMap<>();
	
	public boolean AddProduct(Product product , Integer quantity)
	{
		if(inventory.containsKey(product))
		{
			Integer oldQuantity =inventory.get(product);
			inventory.put(product, oldQuantity+quantity);
			return true;
		}
		inventory.put(product,quantity);
		prodcuctCatalog.put(product.getId(), product);
		return true;
	}
	
	public Product getProduct(Product product) throws ProductNotAvailableException
	{
		if(inventory.containsKey(product))
		{
			Integer oldQuantity =inventory.get(product);
			oldQuantity--;
			inventory.put(product, oldQuantity);
			if(oldQuantity==0)
			{
				inventory.remove(product);
				prodcuctCatalog.remove(product.getId());
			}
			return product;
		}
		
		throw new ProductNotAvailableException("Product is empty please supply new product");
		
	}
	
	public boolean checkProductAvaibility(Product product) 
	{
		if(inventory.containsKey(product))
		{
			
			return true;
		}
		
		return false;
	
	}
	
	public Product getProductDetialFromProductCatalog(Integer id) throws ProductNotAvailableException 
	{
		if(prodcuctCatalog.containsKey(id))
		{
			
			return prodcuctCatalog.get(id);
		}
		
		throw new ProductNotAvailableException("Product is empty please supply new product");
	
	}

	public Integer getremainingProduct(Integer  id) throws ProductNotAvailableException
	{
		Product product= new Product();
		product.setId(id);
		if(inventory.containsKey(product))
		{
			
			return inventory.get(product);
		}

		throw new ProductNotAvailableException("Product is empty please supply new product");
	}
	
}

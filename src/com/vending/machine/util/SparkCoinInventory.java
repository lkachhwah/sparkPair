package com.vending.machine.util;

import java.util.HashMap;
import java.util.Map;

import com.vending.machine.exception.ProductNotAvailableException;
import com.vending.machine.model.Product;
import com.vending.machine.model.SparkCoin;

public class SparkCoinInventory {

	Map<SparkCoin, Integer> inventory = new HashMap<>();
	
	public boolean AddSparkCoin(SparkCoin sparkCoin , Integer quantity)
	{
		if(inventory.containsKey(sparkCoin))
		{
			Integer oldQuantity =inventory.get(sparkCoin);
			inventory.put(sparkCoin, oldQuantity+quantity);
			return true;
		}
		inventory.put(sparkCoin,quantity);
		return true;
	}
	
}

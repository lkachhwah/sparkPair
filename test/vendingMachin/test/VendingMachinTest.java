package vendingMachin.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.junit.Test;

import com.vending.machine.exception.ProductNotAvailableException;
import com.vending.machine.execution.VendingMachine;
import com.vending.machine.model.Product;
import com.vending.machine.model.SparkCoin;

import junit.framework.Assert;

public class VendingMachinTest {
	
	@Test
	public void getProduct() throws ProductNotAvailableException
	{
		VendingMachine vm= new VendingMachine();
		
		Product product = new Product();
		product.setId(1);
		product.setName("SparklingWater(25 Sparks)");
		product.setSparkValue(25);	
		
		vm.addProduct(product, 2);
		
		Map< SparkCoin ,Integer> map= new HashMap<>();
		SparkCoin coin= new  SparkCoin(25);
		map.put(coin, 1);
		
		Product recievedProduct=  vm.getProduct (product.getId(),map);
		
		Assert.assertNotNull(recievedProduct);
		Assert.assertEquals(product, recievedProduct);
		
		Integer remaingCount =vm.getRemainingProduct(1);
		
		Assert.assertEquals(new Integer(1) , remaingCount);
			
	}

}

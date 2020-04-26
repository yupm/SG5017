package sg.edu.nus.iss.vmcs.store;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TempControlTest extends TestCase{
	
	@Before
	public void setup() throws Exception{
	}

	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testStoreObjectConstructor() throws Exception{
		//Act
		int qty = 10;
		String brandName = "CocoCola";
		int price= 100;
		DrinksBrand drinksBrand = new DrinksBrand(brandName, price);
		DrinksStoreItem drinksStoreItem=new DrinksStoreItem(drinksBrand, qty);
		
		//Assert
		assertNotNull(drinksStoreItem);
		assertEquals(drinksStoreItem.getName(),brandName);
	}
	
	@Test
	public void testSetTemp() throws Exception{
		int qty = 10;
		String brandName = "CocoCola";
		int price= 100;
		String temp = "(Hot)";
		DrinksBrand drinksBrand = new DrinksBrand(brandName, price);
		DrinksStoreItem drinksStoreItem=new DrinksStoreItem(drinksBrand, qty);

		//Act setTemp
		drinksStoreItem.setTemp(temp);

		//Act getName
		String drinkTemp=drinksStoreItem.getTemp();
		//Assert
		assertEquals(temp,drinkTemp);
	}
	
	
	@Test
	public void testSetTempName() throws Exception{
		int qty = 10;
		String brandName = "CocoCola";
		int price= 100;
		String temp = "(Hot)";
		DrinksBrand drinksBrand = new DrinksBrand(brandName, price);
		DrinksStoreItem drinksStoreItem=new DrinksStoreItem(drinksBrand, qty);

		//Act setTemp
		drinksStoreItem.setTemp(temp);

		//Act getName
		String drinkName=drinksStoreItem.getName();
		
		//Assert
		assertEquals(temp + brandName,drinkName);
	}
	
}//End of class StoreObjectTest
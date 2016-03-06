package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.Item;
import main.java.SuperMarketConstants;
import main.java.SuperMarketException;
import main.java.SuperMarketPlusPlus;


public class SuperMarketPlusPlusTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	// Test to check Oraganic Banana implementation.
	@Test
	public void testTheItemOrganicBanana() throws SuperMarketException {
		List<Item> items = new ArrayList<Item>();
        items.add(new Item(SuperMarketConstants.THERMAL_VEST, 10, 20));
        items.add(new Item(SuperMarketConstants.AGED_BRIE, 2, 0));
        items.add(new Item(SuperMarketConstants.CHICKEN, 5, 7));
        items.add(new Item(SuperMarketConstants.SULFURAS, 0, 80));
        items.add(new Item(SuperMarketConstants.BACKSTAGE_PASSES, 15, 20));
        items.add(new Item(SuperMarketConstants.GINGER_CAKE, 3, 6));
        items.add(new Item(SuperMarketConstants.ORGANIC_BANANA, 6, 16));
		SuperMarketPlusPlus.items = items;
		SuperMarketPlusPlus.updateQuality();
		
	   assertEquals(14, items.get(6).getQuality());
	}
	
}

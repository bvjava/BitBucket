package main.java;

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("Starting Supermarket Plus Plus");
		
        items = new ArrayList<Item>();
        items.add(new Item(SuperMarketConstants.THERMAL_VEST, 10, 20));
        items.add(new Item(SuperMarketConstants.AGED_BRIE, 2, 0));
        items.add(new Item(SuperMarketConstants.CHICKEN, 5, 7));
        items.add(new Item(SuperMarketConstants.SULFURAS, 0, 80));
        items.add(new Item(SuperMarketConstants.BACKSTAGE_PASSES, 15, 20));
        items.add(new Item(SuperMarketConstants.GINGER_CAKE, 3, 6));
        items.add(new Item(SuperMarketConstants.ORGANIC_BANANA, 6, 16)); // Addition of new item ORGANIC_BANANA to the existing system.

        updateQuality();
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
        	
			if ((!SuperMarketConstants.AGED_BRIE.equals(items.get(i).getName())) && !SuperMarketConstants.BACKSTAGE_PASSES.equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!SuperMarketConstants.SULFURAS.equals(items.get(i).getName()))
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if (SuperMarketConstants.BACKSTAGE_PASSES.equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!SuperMarketConstants.SULFURAS.equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!SuperMarketConstants.AGED_BRIE.equals(items.get(i).getName()))
                {
                    if (!SuperMarketConstants.BACKSTAGE_PASSES.equals(items.get(i).getName()))
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!SuperMarketConstants.SULFURAS.equals(items.get(i).getName()))
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }

}
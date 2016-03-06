package main.java;

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

	public static List<Item> items = null;

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

        try {
			updateQuality();
		} catch (SuperMarketException e) {
			e.printStackTrace();
		}
}


	
    public static void updateQuality() throws SuperMarketException
    {
        for (int i = 0; i < items.size(); i++)
        {
        	
			if ((!SuperMarketConstants.AGED_BRIE.equals(items.get(i).getName())) && !SuperMarketConstants.BACKSTAGE_PASSES.equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!SuperMarketConstants.SULFURAS.equals(items.get(i).getName()))
                    {
                    	//New Implementation : If item is ORGANIC_BANANA then quality will decreased twice than normal items.
                    	if(SuperMarketConstants.ORGANIC_BANANA.equals(items.get(i).getName())){
                    		// Requirement quality can not be negative.
                    		if(items.get(i).getQuality() > 1){
                    			items.get(i).setQuality(items.get(i).getQuality() - 2);
                    		}      
                    		else{
                    			items.get(i).setQuality(0);
                    		}
                    	}
                    	else{
                    		items.get(i).setQuality(items.get(i).getQuality() - 1);
                    	}
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);
                    
                    /* Modification in existing logic according to the requirement:
                     * "Backstage Passes", like aged brie, increases in Quality as it's SellIn value reduces (i.e as it gets closer to the concert). 
                     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
                     */

                    if (SuperMarketConstants.BACKSTAGE_PASSES.equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 2); //Correction. Previously increased by 1.
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 3); //Correction. Previously increased by 1.
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
                            	/* Modified the existing code to meet the requirement:
                            	 * Once the sell by date has passed, Quality degrades twice as fast (i.e. the int is decremented by 2 instead of 1)
                            	 * 
                            	 */
                                items.get(i).setQuality(items.get(i).getQuality() - 2); // Correction. Previously done by 1.
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
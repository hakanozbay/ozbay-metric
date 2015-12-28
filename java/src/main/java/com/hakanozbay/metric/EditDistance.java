package com.hakanozbay.metric;

class EditDistance implements Metric
{

	public double calculate(String base, String term) 
	{
		return calculateLevenshteinDistance(base, term);
	}

	protected int calculateLevenshteinDistance (String base, String term)
	{                          
	    int len0 = base.length() + 1;                                                     
	    int len1 = term.length() + 1;                                                     
	                                                                                    
	    int[] cost = new int[len0];                                                     
	    int[] newcost = new int[len0];                                                  
	                                                                                    
	    for (int i = 0; i < len0; i++) cost[i] = i;                                     
	                                                                                    
	    for (int j = 1; j < len1; j++) {                                                
	        newcost[0] = j;                                                             
	                                                                                    
	        for(int i = 1; i < len0; i++) {                                             
	            int match = (base.charAt(i - 1) == term.charAt(j - 1)) ? 0 : 1;             
	                                                                                    
	            int cost_replace = cost[i - 1] + match;                                 
	            int cost_insert  = cost[i] + 1;                                         
	            int cost_delete  = newcost[i - 1] + 1;                                  
	                                                                                    
	            newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
	        }                                                                           
	                                                                                    
	        int[] swap = cost; cost = newcost; newcost = swap;                          
	    }                                                                               
	                                                                                    
	    return cost[len0 - 1];                                                          
	}
}

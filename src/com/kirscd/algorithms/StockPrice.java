package com.kirscd.algorithms;

/**
 * https://www.interviewcake.com/question/java/stock-price
 *
 */
public class StockPrice {
	  //public static int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
	public static int[] stockPricesYesterday = new int[]{10, 9, 8, 7, 6, 5};

	  public static int getMaxProfit(int[] stockPrices) {
		  if(stockPrices.length < 2) {
			  throw new IllegalArgumentException("Not enough Data");
		  }
		  
		  int minPrice = stockPrices[0];
		  int maxProfit = stockPrices[1] - stockPrices[0];
		  
		  for(int i = 1; i < stockPrices.length; i++) {
			  int potentialProfit = stockPrices[i] - minPrice;
			  
			  maxProfit = Math.max(potentialProfit, maxProfit);
			  minPrice = Math.min(minPrice, stockPrices[i]);
		  }
		  
		  return maxProfit;
	  }
	  
	  public static void main(String args[]) {
		  System.out.println(getMaxProfit(stockPricesYesterday));
	  }
}

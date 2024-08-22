package com.company;

import java.util.ArrayList;
import java.util.List;

public class SilverTrader {
    private List<Integer> dummyPrices = new ArrayList();
//    private Integer maxProfit = null;
    private Integer bestBuyDay = null;
    private Integer bestSellDay = null;

    public SilverTrader() {
        populatePrices();

        Integer maxProfit = null;
        int apiNumberOfDays = 8;
        for(int sellDayIndex = apiNumberOfDays; sellDayIndex > 0 ; sellDayIndex--) {
            int sellPrice = dummyPrices.get(sellDayIndex);
            for(int buyDayIndex = sellDayIndex - 1; buyDayIndex >=0; buyDayIndex--) {
                int profit = sellPrice - dummyPrices.get(buyDayIndex);
                if(maxProfit == null || profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDay = buyDayIndex;
                    bestSellDay = sellDayIndex;
                }
            }
        }
    }

    public int getBuyDay() {
        return this.bestBuyDay;
    }

    public int getSellDay() {
        return this.bestSellDay;
    }

    private void populatePrices() {
        dummyPrices.add(5); //0
        dummyPrices.add(1); //1
        dummyPrices.add(4); //2
        dummyPrices.add(10); //3
        dummyPrices.add(3); //4
        dummyPrices.add(21); //5
        dummyPrices.add(9); //6
        dummyPrices.add(10); //7
        dummyPrices.add(20); //8
    }

}

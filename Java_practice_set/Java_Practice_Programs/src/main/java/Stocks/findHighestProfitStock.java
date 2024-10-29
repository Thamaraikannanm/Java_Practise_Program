package Stocks;

import java.util.*;


public class findHighestProfitStock {

    public static void main(String[] args) {
        List<stock> stockList = Arrays.asList(
                new stock("1", "Maveric", 50000.0, 100, 5000.0),
                new stock("2", "Infosys", 30000.0, 50, 3000.0),
                new stock("3", "Wipro", 80000.0, 200, 10000.0),
                new stock("4", "TechMahendra", 20000.0, 20, 1500.0));

        findHighestProfitStock preferredStocks = new findHighestProfitStock();
        List<stock> recommendedStocks = preferredStocks.recommendStocks(stockList);

        System.out.println("stocks with highest profit in a month from given data:");
        for (stock stocks : recommendedStocks) {
            System.out.println(stocks);
        }
    }

    // This Method used to Sort stocks by expected profit in descending order, So that we can get the highest profit first
    public List<stock> recommendStocks(List<stock> stocks) {
        stocks.sort(Comparator.comparingDouble(stock::getTotalExpectedProfitPerMonth).reversed());
        return stocks;
    }
}

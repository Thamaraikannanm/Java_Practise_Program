package Stocks;

public class stock {

    private String id;
    private String name;
    private double totalValue;
    private long availableUnits;
    private double totalExpectedProfitPerMonth;

    public stock(String id, String name, double totalValue, long availableUnits, double totalExpectedProfitPerMonth) {
        this.id = id;
        this.name = name;
        this.totalValue = totalValue;
        this.availableUnits = availableUnits;
        this.totalExpectedProfitPerMonth = totalExpectedProfitPerMonth;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public long getAvailableUnits() {
        return availableUnits;
    }

    public double getTotalExpectedProfitPerMonth() {
        return totalExpectedProfitPerMonth;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", totalValue=" + totalValue +
                ", availableUnits=" + availableUnits +
                ", totalExpectedProfitPerMonth=" + totalExpectedProfitPerMonth +
                '}';
    }
}

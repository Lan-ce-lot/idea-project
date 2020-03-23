package opp;

public class Test {
    public static void main(String[] args) {

        Stock newStock = new Stock("0RCL", "Oracle Corporation");
        newStock.setPreviousClosingPrice(34.5);
        newStock.setCurrentPrice(34.35);
        System.out.println("前一日的股票值:" + newStock.getPreviousClosingPrice());
        System.out.println("当日的股票值:" + newStock.getCurrentPrice());
        System.out.printf(newStock.name + "股票市值变化的百分比：" + "  %f",(newStock.getChangePercentO() * 100));
        System.out.println("%");
    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String newSymbol, String newName) {
        symbol = newSymbol;
        name = newName;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double newPreviousClosingPrice) {
        previousClosingPrice = newPreviousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double newCurrentPrice) {
        currentPrice = newCurrentPrice;
    }

    public double getChangePercentO() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice;
    }
}
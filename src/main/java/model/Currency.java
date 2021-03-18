package model;

public class Currency {
    private String name;
    private double marketValue;
    private double nextPredictedDelta;

    public Currency(String name, double marketValue, double nextPredictedDelta) {
        this.name = name;
        this.marketValue = marketValue;
        this.nextPredictedDelta = nextPredictedDelta;
    }

    public void crashMarketValue(){
        marketValue -= nextPredictedDelta;
    }
    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getNextPredictedDelta() {
        return nextPredictedDelta;
    }

    public void setNextPredictedDelta(double nextPredictedDelta) {
        this.nextPredictedDelta = nextPredictedDelta;
    }
}

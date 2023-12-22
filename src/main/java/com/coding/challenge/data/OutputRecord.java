package com.coding.challenge.data;

import java.util.Objects;

public class OutputRecord {
    public OutputRecord() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputRecord)) return false;
        OutputRecord that = (OutputRecord) o;
        return getMaxTimeGap() == that.getMaxTimeGap() && getTotalVolumeTraded() == that.getTotalVolumeTraded() && getMaxTradePrice() == that.getMaxTradePrice() && getWeightedAvgPrice() == that.getWeightedAvgPrice() && Objects.equals(getSymbol(), that.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol(), getMaxTimeGap(), getTotalVolumeTraded(), getMaxTradePrice(), getWeightedAvgPrice());
    }

    public String getSymbol() {
        return symbol;
    }

    public OutputRecord(String symbol, int maxTimeGap, int totalVolumeTraded, int maxTradePrice, int weightedAvgPrice) {
        this.symbol = symbol;
        this.maxTimeGap = maxTimeGap;
        this.totalVolumeTraded = totalVolumeTraded;
        this.maxTradePrice = maxTradePrice;
        this.weightedAvgPrice = weightedAvgPrice;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getMaxTimeGap() {
        return maxTimeGap;
    }

    public void setMaxTimeGap(int maxTimeGap) {
        this.maxTimeGap = maxTimeGap;
    }

    public int getTotalVolumeTraded() {
        return totalVolumeTraded;
    }

    public void setTotalVolumeTraded(int totalVolumeTraded) {
        this.totalVolumeTraded = totalVolumeTraded;
    }

    public int getMaxTradePrice() {
        return maxTradePrice;
    }

    public void setMaxTradePrice(int maxTradePrice) {
        this.maxTradePrice = maxTradePrice;
    }

    public int getWeightedAvgPrice() {
        if (numerator != 0 && denominator != 0){
            this.setWeightedAvgPrice((int)(numerator/denominator));
            return (int) (numerator/denominator);
        }
        return weightedAvgPrice;
    }

    public void setWeightedAvgPrice(int weightedAvgPrice) {

        this.weightedAvgPrice = weightedAvgPrice;
    }

    public String symbol;
    public int maxTimeGap;
    public int totalVolumeTraded;
    public int maxTradePrice;
    public int weightedAvgPrice;

    public long getNumerator() {
        return numerator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    public OutputRecord(String symbol, int maxTimeGap, int totalVolumeTraded, int maxTradePrice, int weightedAvgPrice, long numerator, long denominator) {
        this.symbol = symbol;
        this.maxTimeGap = maxTimeGap;
        this.totalVolumeTraded = totalVolumeTraded;
        this.maxTradePrice = maxTradePrice;
        this.weightedAvgPrice = weightedAvgPrice;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long numerator;

    public long denominator;

    public OutputRecord(String symbol, int maxTimeGap, int totalVolumeTraded, int maxTradePrice, int weightedAvgPrice, long numerator, long denominator, int prevTimestamp) {
        this.symbol = symbol;
        this.maxTimeGap = maxTimeGap;
        this.totalVolumeTraded = totalVolumeTraded;
        this.maxTradePrice = maxTradePrice;
        this.weightedAvgPrice = weightedAvgPrice;
        this.numerator = numerator;
        this.denominator = denominator;
        this.prevTimestamp = prevTimestamp;
    }

    public long getPrevTimestamp() {
        return prevTimestamp;
    }

    public void setPrevTimestamp(long prevTimestamp) {
        this.prevTimestamp = prevTimestamp;
    }

    @Override
    public String toString() {
        return "OutputRecord{" +
                "symbol='" + symbol + '\'' +
                ", maxTimeGap=" + maxTimeGap +
                ", totalVolumeTraded=" + totalVolumeTraded +
                ", maxTradePrice=" + maxTradePrice +
                ", weightedAvgPrice=" + this.getWeightedAvgPrice() +
                ", numerator=" + numerator +
                ", denominator=" + denominator +
                ", prevTimestamp=" + prevTimestamp +
                '}';
    }

    public long prevTimestamp;

}

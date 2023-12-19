package com.coding.challenge.data;

public class InputRecord {
    public Long timestamp;
    public String symbol;
    public int quantity;
    public int price;

    public InputRecord(Long timestamp, String symbol, int quantity, int price) {
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }


    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

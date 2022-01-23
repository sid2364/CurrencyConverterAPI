package com.currencyconverter.rest.controller;

public class ConversionRequest {
    private Double notional;
    private String fromCcy;
    private String toCcy;
    private long startTime;

    public ConversionRequest() {
    }

    public Double getNotional() {
        return notional;
    }

    public ConversionRequest setNotional(Double notional) {
        this.notional = notional;
        return this;
    }

    public String getFromCcy() {
        return fromCcy;
    }

    public ConversionRequest setFromCcy(String fromCcy) {
        this.fromCcy = fromCcy;
        return this;
    }

    public String getToCcy() {
        return toCcy;
    }

    public ConversionRequest setToCcy(String toCcy) {
        this.toCcy = toCcy;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

}

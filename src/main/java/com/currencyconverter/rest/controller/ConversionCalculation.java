package com.currencyconverter.rest.controller;

public class ConversionCalculation {
    /* Can also use builder pattern to create instances instead of using 'new' */

    private Double notional;
    private String fromCcy;
    private String toCcy;
    private Double resultNotional;
    private long startTime;
    private long endTime;

    public ConversionCalculation(ConversionRequest conversionRequest) {
        /* Initialise with args from the request */
        this.notional = conversionRequest.getNotional();
        this.fromCcy = conversionRequest.getFromCcy();
        this.toCcy = conversionRequest.getToCcy();
    }

    public Double getNotional() {
        return notional;
    }

    public ConversionCalculation setNotional(Double notional) {
        this.notional = notional;
        return this;
    }

    public String getFromCcy() {
        return fromCcy;
    }

    public ConversionCalculation setFromCcy(String fromCcy) {
        this.fromCcy = fromCcy;
        return this;
    }

    public String getToCcy() {
        return toCcy;
    }

    public ConversionCalculation setToCcy(String toCcy) {
        this.toCcy = toCcy;
        return this;
    }

    public Double getResultNotional() {
        return resultNotional;
    }

    public ConversionCalculation setResultNotional(Double resultNotional) {
        this.resultNotional = resultNotional;
        return this;
    }

    public ConversionCalculation setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    public long getEndTime(){
        return endTime;
    }

    public ConversionCalculation setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }
    public long getStartTime() {
        return this.startTime;
    }
}

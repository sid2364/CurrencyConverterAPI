package com.currencyconverter.rest.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) /* Don't send back since we aren't setting them in the response */
public class ConversionResponse implements Serializable {

    /* Required to send "back" a serialised response! */
    private String queryTime;
    private String fromCcy;
    private String toCcy;
    private Double notional;
    private Double resultNotional;
    private Double durationInSeconds;
    private Long startTime;
    private Long endTime;
    public String errorMessage;

    private static String getTime(){
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    private static double calculationDuration(long startTime, long endTime) {
        /* Convert nanoTime to seconds */
        return ((double)endTime - startTime) / 1_000_000_000;
    }

    public static ConversionResponse from(ConversionCalculation conversionCalculation) {
        return ConversionResponse
                .builder()
                .queryTime(getTime())
                .toCcy(conversionCalculation.getToCcy())
                .fromCcy(conversionCalculation.getFromCcy())
                .notional(conversionCalculation.getNotional())
                .resultNotional(conversionCalculation.getResultNotional())
                .durationInSeconds(calculationDuration(conversionCalculation.getStartTime(), conversionCalculation.getEndTime()))
                .build();
    }

    public static ConversionResponse from(String errorMessage){
        return ConversionResponse
                .builder()
                .errorMessage(errorMessage)
                .build();
    }

}

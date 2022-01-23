package com.currency.helpers;

import com.currency.rest.controller.ConversionCalculation;
import com.currency.rest.controller.ConversionRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversionCalculationUtil {

    ConversionCalculation convert(FXRates exchangeRate, ConversionRequest conversionRequest) {
        ConversionCalculation conversionCalculation = new ConversionCalculation(conversionRequest);

        Double result = roundedMultiply(
                exchangeRate.getRates().get(conversionRequest.getToCcy()),
                conversionRequest.getNotional());

        conversionCalculation.setResultNotional(result);
        return conversionCalculation;
    }

    public static Double roundedMultiply(Double rate, Double amount) {
        double result = rate * amount;
        BigDecimal roundedResult = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return roundedResult.doubleValue();
    }

}

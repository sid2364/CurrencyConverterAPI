package com.currency.helpers;

import com.currency.rest.controller.ConversionCalculation;
import com.currency.rest.controller.ConversionRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
@AllArgsConstructor
public class ServiceUtil {

    @Autowired
    FXRateDataRetrieverUtil FXRateDataRetrieverUtil;

    public ConversionCalculation convert(ConversionRequest conversionRequest) {

        FXRates fxRates = FXRateDataRetrieverUtil.getFXRate(conversionRequest.getFromCcy(), conversionRequest.getToCcy());
        ConversionCalculation conversionCalculation = new ConversionCalculation(conversionRequest);

        Double result = roundedMultiply(
                fxRates.getRates().get(conversionRequest.getToCcy()),
                conversionRequest.getNotional());

        conversionCalculation.setResultNotional(result);
        conversionCalculation.setStartTime(conversionRequest.getStartTime());

        long endTime = System.nanoTime();
        conversionCalculation.setEndTime(endTime);

        return conversionCalculation;
    }

    public static Double roundedMultiply(Double rate, Double amount) {
        double result = rate * amount;
        BigDecimal roundedResult = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return roundedResult.doubleValue();
    }

}

package com.currencyconverter.rest.controller;

import com.currencyconverter.helpers.ServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@AllArgsConstructor
public class ConversionController {

    private final ServiceUtil ServiceUtil;
    private final String errorMessage = "There was an error on the client side while processing your inputs. " +
            "Please try again with valid 3-letter currency codes.";

    @RequestMapping("/convert")
    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ConversionResponse convert(Double notional, String fromCcy, String toCcy) {
        /* Entry point for the /convert endpoint */
        long startTime = System.nanoTime();

        ConversionRequest conversionRequest = new ConversionRequest();
        conversionRequest
                .setFromCcy(fromCcy.toUpperCase())
                .setToCcy(toCcy.toUpperCase())
                .setNotional(notional)
                .setStartTime(startTime);

        try {
            ConversionCalculation conversionCalculation = ServiceUtil.convert(conversionRequest);
            return ConversionResponse.from(conversionCalculation);
        } catch (HttpClientErrorException exception){
            return ConversionResponse.from(errorMessage);
        }
    }

    @RequestMapping("/**")
    public String defaultResponse(){
        return "Usage: /convert?notional=[Double]&fromCcy=[String]&toCcy=[String]";
    }

}
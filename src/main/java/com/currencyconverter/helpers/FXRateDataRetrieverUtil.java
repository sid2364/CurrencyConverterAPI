package com.currencyconverter.helpers;

import java.net.URI;

import lombok.AllArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
public class FXRateDataRetrieverUtil {

    private String accessKey;
    private BridgeUtil bridgeUtil;
    private String url;

    FXRates getFXRate(String fromCcy, String toCcy) {
        URI targetUrl = UriComponentsBuilder.fromUriString(url).path("/latest")
                                            .queryParam("access_key", accessKey)
                                            .queryParam("base", fromCcy)
                                            .queryParam("symbols", toCcy)
                                            .build().encode().toUri();

        return bridgeUtil.getCurrencyData(targetUrl, FXRates.class);
    }

}

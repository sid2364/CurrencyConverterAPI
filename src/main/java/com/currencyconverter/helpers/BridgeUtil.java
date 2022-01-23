package com.currencyconverter.helpers;

import lombok.Value;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Value
public class BridgeUtil {

    private RestTemplate restTemplate;

    @Nullable
    public <T> T getCurrencyData(URI url, Class<T> responseType) throws RestClientException {
        return restTemplate.getForObject(url, responseType);
    }

}

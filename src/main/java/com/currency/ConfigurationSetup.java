package com.currency;

import com.currency.helpers.ServiceUtil;
import com.currency.helpers.BridgeUtil;
import com.currency.helpers.FXRateDataRetrieverUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@ComponentScan
@Configuration
public class ConfigurationSetup {

    @Value("${exchangeRatesAPI.location}")
    private String URL;

    @Value("${exchangeRatesAPI.accessKey}")
    private String accessKey;

    @Bean
    public FXRateDataRetrieverUtil getDataRetrieverUtil() {
        return new FXRateDataRetrieverUtil(accessKey, new BridgeUtil(new RestTemplate()), URL);
    }

    @Bean
    public String getAccessKey() {
        return accessKey;
    }

    @Bean
    public ServiceUtil getServiceUtil() {
        return new ServiceUtil();
    }
}

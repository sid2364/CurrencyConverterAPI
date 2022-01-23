# CurrencyConverterAPI
Simple REST API that be used for converting one currency value into another.

## Endpoints
#### /convert?notional=1&FromCcy=EUR&ToCcy=USD
```
{
   "queryTime": "20220124 00:31:55",
   "toCcy": "USD",
   "notional": 10,
   "resultNotional": 11.34,
   "durationInSeconds": 0.6620257
}
```

## Heroku Deployment
https://currencyconverter-nosto.herokuapp.com/convert?notional=95.67&fromCcy=EUR&toCcy=INR
package com.geoflev.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//APO EDW GINETAI H KLHSH STO APPLICATION EXCHANGE

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//afou kanw load balancing me to ribbon pleon de xreiazomai to url
//tha to kanw configure sto application.properties
	

//allazw to feign wste na briskei ton exchange app mesw api gateway (Zuul) anti gia directly
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")

@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//gia to zuul allazw kai to url 
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}

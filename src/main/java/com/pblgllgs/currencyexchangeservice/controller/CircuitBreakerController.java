package com.pblgllgs.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample")
//    @Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
//    @CircuitBreaker(name = "sample-api",fallbackMethod = "hardCodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead( name = "sample-api")
    public String sampleApi() {
        logger.info("sample api call received");
//        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/pblgllgs", String.class);
        return "sample-api";
    }

    public String hardCodedResponse(Exception ex){
    return "fallback-response";
    }
}

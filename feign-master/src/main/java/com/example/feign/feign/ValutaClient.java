package com.example.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "valuta", url = "${feign.client.url.valuta}")
public interface ValutaClient {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Map> getWeather();
}

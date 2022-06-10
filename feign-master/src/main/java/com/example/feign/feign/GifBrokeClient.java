package com.example.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "GifBroke", url = "${feign.client.url.gif}&tag=broke&rating=g")
public interface GifBrokeClient {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Map> getGifBroke();
}

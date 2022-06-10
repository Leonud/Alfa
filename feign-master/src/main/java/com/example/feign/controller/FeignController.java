package com.example.feign.controller;

import com.example.feign.feign.GifBrokeClient;
import com.example.feign.feign.GifRichClient;
import com.example.feign.feign.IWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class FeignController {

    private final IWeatherClient weatherClient;
    private final GifBrokeClient gifBrokeClient;
    private final GifRichClient gifRichClient;

    @Autowired
    public FeignController(IWeatherClient weatherClient, GifBrokeClient gifBrokeClient, GifRichClient gifRichClient) {
        this.weatherClient = weatherClient;
        this.gifBrokeClient = gifBrokeClient;
        this.gifRichClient = gifRichClient;
    }

    @GetMapping(path = "/cash")
    ResponseEntity<Map> getWeather() {
        return ResponseEntity.ok(weatherClient.getWeather().getBody());
    }

    @GetMapping(path = "/rich")
    ResponseEntity<Map> getGifRich() {
        return ResponseEntity.ok(gifRichClient.getGifRich().getBody());
    }

    @GetMapping(path = "/broke")
    ResponseEntity<Map> GifBrokeClient() {
        return ResponseEntity.ok(gifBrokeClient.getGifBroke().getBody());
    }
}
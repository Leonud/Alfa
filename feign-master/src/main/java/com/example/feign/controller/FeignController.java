package com.example.feign.controller;
import com.example.feign.feign.GifBrokeClient;
import com.example.feign.feign.GifRichClient;
import com.example.feign.feign.ValutaClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@Service
@Slf4j
@RestController
public class FeignController {
    private static ValutaClient currencyValue = null;
    private static GifBrokeClient gifBrokeClient = null;
    private static GifRichClient gifRichClient = null;


    @Autowired
    public FeignController(ValutaClient currencyValue, GifBrokeClient gifBrokeClient, GifRichClient gifRichClient) {
        this.currencyValue = currencyValue;
        this.gifBrokeClient = gifBrokeClient;
        this.gifRichClient = gifRichClient;
    }

    public static String getGifRichLink() {
        long time = System.currentTimeMillis();
        while (true) {
            try {
                Map rich = gifRichClient.getGifRich().getBody();
                Gson g = new Gson();
                JsonElement str = g.toJsonTree(rich.get("data"));
                JsonObject jsonObject = str.getAsJsonObject();
                String link = jsonObject.get("images").getAsJsonObject().get("fixed_height_downsampled").getAsJsonObject().get("url").toString();
                return link;
            } catch (Exception e) {
                long time_ = System.currentTimeMillis() - time;
                if (time_ / 1000 > 20){
                    return e.toString();
                }
                continue;
            }
        }
    }

    public static String getGifBrokeLink() {
        long time = System.currentTimeMillis();
        while (true) {
            try {
                Map Broke = gifBrokeClient.getGifBroke().getBody();
                Gson g = new Gson();
                JsonElement str = g.toJsonTree(Broke.get("data"));
                JsonObject jsonObject = str.getAsJsonObject();
                String link = jsonObject.get("images").getAsJsonObject().get("fixed_height_downsampled").getAsJsonObject().get("url").toString();
                return link;
            } catch (Exception e) {
                long time_ = System.currentTimeMillis() - time;
                if (time_ / 1000 > 20){
                    return e.toString();
                }
                continue;
            }
        }
    }

    public static Map<String, String> valuta() {
        long time = System.currentTimeMillis();
        while (true) {
            try {
                Map<String, String> valet_ = new HashMap<>();

                Map rich = currencyValue.getWeather().getBody();
                Gson g = new Gson();
                JsonElement str = g.toJsonTree(rich.get("rates"));
                JsonObject jsonObject = str.getAsJsonObject();

                Set<String> keys = jsonObject.keySet();
                keys.forEach((e) -> { valet_.put(e, jsonObject.get(e).toString()); });

                return valet_;
            } catch (Exception e) {
                long time_ = System.currentTimeMillis() - time;
                if (time_ / 1000 > 20){
                    Map<String, String> error = new HashMap<>();
                    error.put("error", e.toString());
                    return error;
                }
                continue;
            }
        }
    }

}
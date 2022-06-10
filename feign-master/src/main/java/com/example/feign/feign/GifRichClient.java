package com.example.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "GifRich", url = "${feign.client.url.gif}&tag=rich&rating=g")
public interface GifRichClient {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Map> getGifRich();

}

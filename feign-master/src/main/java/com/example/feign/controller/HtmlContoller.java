package com.example.feign.controller;

import com.example.feign.feign.GifBrokeClient;
import com.example.feign.feign.GifRichClient;
import com.example.feign.feign.ValutaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.*;
import java.util.Map;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Controller
@RequestMapping("/")
public class HtmlContoller extends FeignController {
    public HtmlContoller(ValutaClient currencyValue, GifBrokeClient gifBrokeClient, GifRichClient gifRichClient) {
        super(currencyValue, gifBrokeClient, gifRichClient);
    }

    Map<String, String> OldValuta = valuta();

    @Autowired
    Config config;

    @GetMapping("/valuta")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        Map<String, String> NewValuta = valuta();

        String ValutaName = config.getValutaName();
        if (Float.parseFloat(OldValuta.get(ValutaName)) > Float.parseFloat(NewValuta.get(ValutaName))){
            model.addAttribute("link", getGifBrokeLink());
        } else {
            model.addAttribute("link", getGifRichLink());
        }
        return new ModelAndView("redirect:valuta.html", model);
    }

}
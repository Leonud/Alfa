package com.test.feign;

import static  com.example.feign.controller.FeignController.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

    @Test
    public void testfeignController() {
        String Rich = getGifRichLink();//.lastIndexOf(".gif?");
        String Broke = getGifBrokeLink();//.lastIndexOf(".gif?");
        Map<String, String> Valuta = valuta();

        System.out.println("Api Gif");
        System.out.print("Rich");
        if (Rich.lastIndexOf(".gif?") == -1){ System.out.println(Rich);}
        else {System.out.println("Ok");}

        System.out.print("Broke");
        if (Broke.lastIndexOf(".gif?") == -1){ System.out.println(Broke);}
        else {System.out.println("Ok");}

        System.out.print("Api Valuta");
        if (Valuta.containsKey("error")){ System.out.println(Valuta.get("error"));}
        else {System.out.println("Ok");}
    }
}

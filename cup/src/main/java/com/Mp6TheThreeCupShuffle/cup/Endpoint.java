package com.Mp6TheThreeCupShuffle.cup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    private String coin="0";

    @GetMapping("/cup")
    String get(){
        return  coin;
    }


    @PostMapping("/cup")
    String post(@RequestBody String message) {
        coin = message;
        return coin;
    }
}

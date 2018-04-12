package com.Mp6.The.Three.Cup.Shuffle.trickster;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class Trickster {


@GetMapping("/play")
    void putthecoin(){
    List<String> urllist=  new ArrayList();
    String url1 = "http://localhost:9001/cup";
    String url2 = "http://localhost:9002/cup";
    String url3 = "http://localhost:9003/cup";
    urllist.add(url1);
    urllist.add(url2);
    urllist.add(url3);

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForEntity(url1,"no coin",String.class);
    restTemplate.postForEntity(url2,"no coin",String.class);
    restTemplate.postForEntity(url3,"no coin",String.class);
    Collections.shuffle(urllist);
    restTemplate.postForEntity(urllist.get(0),"coin",String.class);
}
    @GetMapping("/choose/{portnumber}")
    String choosecup(@PathVariable String portnumber){

        List<String> urllist=  new ArrayList();
        String url1 = "http://localhost:9001/cup";
        String url2 = "http://localhost:9002/cup";
        String url3 = "http://localhost:9003/cup";
        urllist.add(url1);
        urllist.add(url2);
        urllist.add(url3);

        RestTemplate restTemplate = new RestTemplate();
        for(String url : urllist){
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            if (forEntity.getBody().contains("coin")&& url.contains(portnumber)){
                return " i dont found it";

            }
            else{
                return "i  found it";
            }
        }

        return null;

    }




}

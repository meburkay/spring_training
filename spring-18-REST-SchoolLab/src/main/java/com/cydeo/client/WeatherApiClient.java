package com.cydeo.client;

import com.cydeo.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//We will consume data from a weather api. We put its base address to here.
@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherApiClient {

    //At the apis documentation when you send request you must give an access_key and query for search purpose. We signup and have an accesskey from the site. When we consume data from this api we will send this request with the parameters as the document says.
    @GetMapping("/current")
    WeatherDTO getCurrentWeather(@RequestParam(value = "access_key") String key,
                                 @RequestParam(value = "query") String city);

}

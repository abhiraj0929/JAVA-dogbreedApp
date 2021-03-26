package com.dogsbreed.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.boot.autoconfigure.mongo.embedded.DownloadConfigBuilderCustomizer;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController()
public class DogBreedController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public String getInfo(@PathVariable(value = "movieId") String searchWord) {
		try {
		String ms = restTemplate.getForObject(
				"https://api.thecatapi.com/v1/breeds/search?q=" + searchWord, String.class);
		System.out.println("THE RESPONSE IS " + ms);
		return ms;
	
		}
		catch(Exception e) {
			e.getMessage();
		}
		return searchWord;
	}

}

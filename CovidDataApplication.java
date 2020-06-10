package com.example.coviddata;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CovidDataApplication {

	public static void main(String[] args) throws Exception {
		//set up web client and retrieve json
		WebClient client = WebClient.create("https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S");
		String json = client.get().uri("/records/LATEST?disableRedirect=true")
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class).block();
		
		//map json to country and print statistics
		ObjectMapper mapper = new ObjectMapper();
		Country[] pp1 = mapper.readValue(json, Country[].class);
		List<Country> ppl2 = Arrays.asList(mapper.readValue(json, Country[].class));
		CountryData countryData = new CountryData(ppl2);
		countryData.compare();
	}
	
}

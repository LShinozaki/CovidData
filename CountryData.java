package com.example.coviddata;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class CountryData {
	private List<Country> countryStats;
	private int worldInfected;
	private int worldDeceased;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public CountryData() {
		
	}

	public CountryData(List<Country> countryStats) {
		this.countryStats = countryStats;
		this.worldInfected = countryStats.stream().collect(Collectors.summingInt(Country::getInfected));
		this.worldDeceased = countryStats.stream().collect(Collectors.summingInt(Country::getDeceased));
	}
	
	//Sort and list country infected and death statistics
	
	public void compare() {
		countryStats.stream().sorted().forEach(country ->{
			StringBuilder str 
            = new StringBuilder();
			str.append(country.getCountry());
			str.append(" / infected:" + df.format((double) country.getInfected() * 100 / this.worldInfected) + "%");
			str.append(" / deceased:" + df.format((double) country.getDeceased() * 100 / this.worldDeceased) + "%");
			System.out.println(str.toString());
		});
	}
}

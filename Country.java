package com.example.coviddata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Comparable<Country>{
		private String country;
		private int infected;
		private int deceased;
		
		public Country() {
			
		}
		
		public Country(String name, int infected, int recovered, int deceased) {
			this.country = name;
			this.infected = infected;
			this.deceased = deceased;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getInfected() {
			return infected;
		}

		public void setInfected(int infected) {
			this.infected = infected;
		}

		public int getDeceased() {
			return deceased;
		}

		public void setDeceased(int deceased) {
			this.deceased = deceased;
		}

		@Override
		public String toString() {
			return country + deceased + " / " + infected;
		}

		@Override
		public int compareTo(Country comparedCountry) {
			if(this.deceased == comparedCountry.deceased) {
				return 0;
			}
			else if(this.deceased < comparedCountry.deceased) {
				return 1;
			}
			else {
				return -1;
			}
		}

		
		
}

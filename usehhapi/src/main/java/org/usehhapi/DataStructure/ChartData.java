package org.usehhapi.DataStructure;

public class ChartData {
	
		private String city;
		private int count;
		
		public ChartData( String city, int count) {
			this.city = city;
			this.count = count;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public void add() {
			this.count++;
		}
}

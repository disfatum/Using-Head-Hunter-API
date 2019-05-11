package org.usehhapi.DataStructure;

public class Vacancy {
		private String id;
		private String name;
		private String city;
		private String URL;
		private int Allkeys;
		private int findkeys;

		public Vacancy(String id, String name,String city, String URL, int Allkeys, int findkeys) {
			this.id = id;
			this.name = name;
			this.URL = URL;
			this.Allkeys = Allkeys;
			this.findkeys = findkeys;
			this.city = city;
		}
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getAllkeys() {
			return Allkeys;
		}

		public void setAllkeys(int allkeys) {
			Allkeys = allkeys;
		}

		public int getFindkeys() {
			return findkeys;
		}

		public void setFindkeys(int findkeys) {
			this.findkeys = findkeys;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getURL() {
			return URL;
		}

		public void setURL(String uRL) {
			URL = uRL;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
}

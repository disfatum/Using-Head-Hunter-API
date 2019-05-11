package org.usehhapi.DataStructure;

public class Settings {
	
		private String region;
		private String numbervac;
		private String exp;
		
		public Settings (String region, String numbervac, Experience exp) {
			
			this.region = region;
			this.numbervac = numbervac;
			this.exp = exp.getExp();
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getNumbervac() {
			return numbervac;
		}
		public void setNumbervac(String numbervac) {
			this.numbervac = numbervac;
		}
		public String getExp() {
			return exp;
		}
		public void setExp(String exp) {
			this.exp = exp;
		}
}

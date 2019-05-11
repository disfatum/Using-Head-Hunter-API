package org.usehhapi.DataStructure;

public class Areas {
	
		private String id;
		private String name;
		
		public Areas(Object id, Object name) {
			this.id = id.toString();
			this.name = name.toString();
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}

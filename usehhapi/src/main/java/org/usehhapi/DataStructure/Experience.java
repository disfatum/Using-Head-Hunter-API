package org.usehhapi.DataStructure;

public class Experience {
		
	private String exp;
	private String CodeExp;
	
	public Experience(String exp, String CodeExp) {
		this.exp = exp;
		this.CodeExp = CodeExp;
	}
	
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getCodeExp() {
		return CodeExp;
	}
	public void setCodeExp(String codeExp) {
		CodeExp = codeExp;
	}
}

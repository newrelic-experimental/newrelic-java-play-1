package com.nr.fit.instrumentation.playws;

import java.net.URI;

public class ParamsInfo {

	protected URI uri;
	protected String procedure = "Unknown";
	
	public ParamsInfo() {
		
	}
	
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	
	
	
}

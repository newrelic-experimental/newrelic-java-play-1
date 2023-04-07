package com.nr.fit.instrumentation.playws;

import play.libs.WS.HttpResponse;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.InboundHeaders;

public class InWrapper implements InboundHeaders {

	private HttpResponse response = null;
	
	public InWrapper(HttpResponse h) {
		response = h;
	}


	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return response.getHeader(name);
	}

}

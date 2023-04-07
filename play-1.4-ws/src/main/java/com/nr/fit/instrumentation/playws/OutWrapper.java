package com.nr.fit.instrumentation.playws;

import java.util.Map;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.OutboundHeaders;

public class OutWrapper implements OutboundHeaders {
	
	private Map<String, String> headers = null;
	
	public OutWrapper(Map<String,String> h) {
		headers = h;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public void setHeader(String name, String value) {
		headers.put(name, value);
	}

}

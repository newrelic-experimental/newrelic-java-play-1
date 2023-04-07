package play.libs;



import play.libs.WS.HttpResponse;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.InboundHeaders;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.fit.instrumentation.playws.InWrapper;
import com.nr.fit.instrumentation.playws.ParamsInfo;

@Weave
public class F {
	
	@Weave(type=MatchType.BaseClass)
	public static class Promise<T> {

		@NewField
		public Token token = null;

		@NewField
		public Segment segment = null;

		@NewField
		public ParamsInfo info = null;

		@Trace(async=true)
		public boolean cancel(boolean mayInterruptIfRunning) {
			if(token != null) {
				token.linkAndExpire();
				token = null;
			}
			if(segment != null) {
				if(info != null) {
					HttpParameters params = null;
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
					segment.reportAsExternal(params);
					info = null;
				}
				segment.end();
				segment = null;
			} else if(info != null) {
				HttpParameters params = null;
				params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
				NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
				info = null;
			}
			return Weaver.callOriginal();
		}

		@Trace(async=true)
		public void invoke(T result) {
			if(token != null) {
				token.linkAndExpire();
				token = null;
			}
			if(segment != null) {
				if(info != null) {
					HttpParameters params = null;
					InboundHeaders inboundHeaders = null;
					if(HttpResponse.class.isInstance(result)) {
						HttpResponse response = (HttpResponse)result;
						inboundHeaders = new InWrapper(response);
					}
					if(inboundHeaders != null) {
						params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).inboundHeaders(inboundHeaders).build();
					} else {
						params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
					}
					segment.reportAsExternal(params);
					info = null;
				}
				segment.end();
				segment = null;
			} else if(info != null) {
				HttpParameters params = null;
				InboundHeaders inboundHeaders = null;
				if(HttpResponse.class.isInstance(result)) {
					HttpResponse response = (HttpResponse)result;
					inboundHeaders = new InWrapper(response);
				}
				if(inboundHeaders != null) {
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).inboundHeaders(inboundHeaders).build();
				} else {
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
				}
				NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
				info = null;
			}
			Weaver.callOriginal();
		}

		@Trace(async=true)
		public void invokeWithException(Throwable t) {
			if(token != null) {
				token.linkAndExpire();
				token = null;
			}
			if(segment != null) {
				if(info != null) {
					HttpParameters params = null;
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
					segment.reportAsExternal(params);
					info = null;
				}
				segment.end();
				segment = null;
			} else if(info != null) {
				HttpParameters params = null;
				params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
				NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
				info = null;
			}
			Weaver.callOriginal();
		}

		@Trace(async=true)
		protected void invokeWithResultOrException(T result, Throwable t) {
			if(token != null) {
				token.linkAndExpire();
				token = null;
			}
			if(segment != null) {
				if(info != null) {
					HttpParameters params = null;
					InboundHeaders inboundHeaders = null;
					if(HttpResponse.class.isInstance(result)) {
						HttpResponse response = (HttpResponse)result;
						inboundHeaders = new InWrapper(response);
					}
					if(inboundHeaders != null) {
						params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).inboundHeaders(inboundHeaders).build();
					} else {
						params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
					}
					segment.reportAsExternal(params);
					info = null;
				}
				segment.end();
				segment = null;
			} else if(info != null) {
				HttpParameters params = null;
				InboundHeaders inboundHeaders = null;
				if(HttpResponse.class.isInstance(result)) {
					HttpResponse response = (HttpResponse)result;
					inboundHeaders = new InWrapper(response);
				}
				if(inboundHeaders != null) {
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).inboundHeaders(inboundHeaders).build();
				} else {
					params = HttpParameters.library("Play-WS").uri(info.getUri()).procedure(info.getProcedure()).noInboundHeaders().build();
				}
				NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
				info = null;
			}
			Weaver.callOriginal();
		}


	}
}

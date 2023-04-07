package play.libs.ws;

import java.net.URI;

import play.libs.F.Promise;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.fit.instrumentation.playws.InWrapper;
import com.nr.fit.instrumentation.playws.OutWrapper;
import com.nr.fit.instrumentation.playws.*;

@Weave
public abstract class WSAsync {

	@Weave
	public abstract static class WSAsyncRequest extends WSRequest {
		
		@Trace
		public HttpResponse delete() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("delete").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> deleteAsync()  {
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("deleteAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-delete");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse get() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("get").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> getAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("getAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-get");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse head() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("head").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> headAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("headAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-head");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse options() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("options").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> optionsAsync() {
			Transaction txn = NewRelic.getAgent().getTransaction();
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("optionsAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-options");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse patch() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("patch").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> patchAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("patchAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-patch");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse put() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("put").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}

		@Trace
		public Promise<HttpResponse> putAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("putAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-put");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse post() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("post").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}

		@Trace
		public Promise<HttpResponse> postAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("postAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-post");
			promise.info = paramsInfo;
			
			return promise;
		}
		
		@Trace
		public HttpResponse trace() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			URI uri = URI.create(url);
			HttpResponse response = Weaver.callOriginal();
			InWrapper inWrapper = new InWrapper(response);
			
			HttpParameters params = HttpParameters.library("Play-WS").uri(uri).procedure("trace").inboundHeaders(inWrapper).build();
			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
			return response;
		}
		
		@Trace
		public Promise<HttpResponse> traceAsync() {
			OutWrapper wrapper = new OutWrapper(headers);
			NewRelic.getAgent().getTracedMethod().addOutboundRequestHeaders(wrapper);
			Transaction txn = NewRelic.getAgent().getTransaction();
			Promise<HttpResponse> promise = Weaver.callOriginal();
			URI uri = URI.create(url);
			ParamsInfo paramsInfo = new ParamsInfo();
			paramsInfo.setProcedure("traceAsync");
			paramsInfo.setUri(uri);
			promise.token = txn.getToken();
			promise.segment = txn.startSegment("WSAsync-trace");
			promise.info = paramsInfo;
			
			return promise;
		}
 	}
}

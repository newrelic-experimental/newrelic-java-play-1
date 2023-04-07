package com.nr.instrumentation.play1_4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import play.mvc.Http.Request;
import play.mvc.Http.Response;

@Weave(originalName="play.mvc.ActionInvoker")
public abstract class ActionInvoker_instrumentation {
	
	@Trace
	public static void invoke(Request request, Response response) {
		Weaver.callOriginal();
	}
	
	public static void resolve(Request request, Response response) {
		Weaver.callOriginal();
		List<String> names = new ArrayList<String>();
		if(request.controller != null) {
			names.add(request.controller); 
		} 
		if(request.actionMethod != null) {
			names.add(request.actionMethod);
		} else if(request.action != null) {
			names.add(request.action);
		}
		if (names.size() > 0) {
			String[] namesArray = new String[names.size()];
			names.toArray(namesArray);
			NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_LOW, false, "Play", namesArray);
		}
		
	}

	@Trace
	public static Object invokeControllerMethod(Method method, Object[] forceArgs) {
		Class<?> controllerClass = method.getDeclaringClass();
		if(controllerClass != null) {
			String controller = controllerClass.getSimpleName();
			String methodName = method.getName();
			NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","ActionInvoker",controller,methodName});
		}
		return Weaver.callOriginal();
	}
	
}

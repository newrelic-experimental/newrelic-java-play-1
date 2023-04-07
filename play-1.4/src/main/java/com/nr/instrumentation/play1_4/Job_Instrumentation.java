package com.nr.instrumentation.play1_4;

import java.util.HashMap;

import play.exceptions.PlayException;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass,originalName="play.jobs.Job")
public abstract class Job_Instrumentation<V> {

	@Trace(dispatcher=true)
	public V call()  {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Job",getClass().getName(),"call"});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void doJob() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Job",getClass().getName(),"doJob"});
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public V doJobWithResult() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Job",getClass().getName(),"doJobWithResult"});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void execute() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Job",getClass().getName(),"execute"});
		Weaver.callOriginal();
	}
	
	public void onException(Throwable e) {
		if(PlayException.class.isInstance(e)) {
			PlayException e1 = (PlayException)e;
			HashMap<String, String> errorMap = new HashMap<String, String>();
			String errorTitle = e1.getErrorTitle();
			if(errorTitle != null && !errorTitle.isEmpty()) {
				errorMap.put("Error Title", errorTitle);
			}
			String descr = e1.getErrorDescription();
			if(descr != null && !descr.isEmpty()) {
				errorMap.put("Error Description", descr);
			}
			errorMap.put("Id", e1.getId());
			Integer lineNo = e1.getLineNumber();
			if(lineNo != null) {
				errorMap.put("Line Number", lineNo.toString());
			}
			String sourceFile = e1.getSourceFile();
			if(sourceFile != null && !sourceFile.isEmpty()) {
				errorMap.put("Error SourceFile", sourceFile);
			}
			NewRelic.noticeError(e1, errorMap);
		} else {
			NewRelic.noticeError(e);
		}
		
		Weaver.callOriginal();
	}
}

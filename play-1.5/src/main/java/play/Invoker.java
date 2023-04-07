package play;

import java.util.concurrent.Future;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public class Invoker {
	
	@Trace
	public static Future<?> invoke(Invocation invocation) {
		return Weaver.callOriginal();
	}

	@Weave(type = MatchType.BaseClass)
	public abstract static class Invocation {
		
		@Trace
		public void execute() {
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Play","Invocation",getClass().getSimpleName(),"execute");
			Weaver.callOriginal();
		}
		
		public void onException(final Throwable e) {
			NewRelic.noticeError(e);
			Weaver.callOriginal();
		}
		
		@Trace
		public void suspend(final Suspend suspendRequest) {
			Weaver.callOriginal();
		}
	}
	
	@Weave
	public static class Suspend {
		
	}
}

import chainedfsm.FSM;
import events.EventBase;

/**
 * Created by Per Malmberg on 2015-11-23.
 */
public class FsmExample extends FSM<TestBaseState> {

	public void event(EventBase ev) {
		TestBaseState state = getCurrentState();
		if (state != null) {
			ev.Visit(state);
		}
	}
}

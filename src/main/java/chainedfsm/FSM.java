package chainedfsm;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class FSM<BaseState extends EnterLeaveState> {
	private BaseState myState = null;

	public void setState(BaseState state) {
		if (state != null) {
			if (myState != null) {
				myState.doLeave();
			}

			myState = state;
			myState.doEnter();
		}
	}

	public BaseState getCurrentState() {
		return myState;
	}

}

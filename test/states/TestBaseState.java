package states;

import chainedfsm.EnterLeaveState;
import chainedfsm.FSM;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public abstract class TestBaseState extends EnterLeaveState {
	private final FSM<TestBaseState> myFsm;
	protected int count = 0;

	public TestBaseState(FSM<TestBaseState> fsm) {
		myFsm = fsm;
	}

	protected FSM<TestBaseState> getFsm() {
		return myFsm;
	}

	public int getCount() {
		return count;
	}
}

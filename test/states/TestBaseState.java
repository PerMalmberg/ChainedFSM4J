package states;

import chainedfsm.EnterLeaveState;
import chainedfsm.FSM;
import events.EventA;
import events.EventB;
import events.IEventListener;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public abstract class TestBaseState extends EnterLeaveState implements IEventListener {
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

	@Override
	public void accept(EventA a) {
	}

	@Override
	public void accept(EventB b) {
	}
}

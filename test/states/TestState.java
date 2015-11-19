package states;

import chainedfsm.EnterChain;
import chainedfsm.LeaveChain;
import chainedfsm.interfaces.IEnter;
import chainedfsm.interfaces.ILeave;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class TestState extends TestBaseState {

	public TestState(chainedfsm.FSM<TestBaseState> fsm) {
		super(fsm);

		new EnterChain<TestState>(this, new IEnter() {
			@Override
			public void enter() {
				// We can access private fields of TestState from here
				++count;
				System.out.println("enter: Hello from TestState: " + count);
			}
		});

		new LeaveChain<TestState>(this, new ILeave() {
			@Override
			public void leave() {
				// We can access private fields of TestState from here
				--count;
				System.out.println("leave: Goodbye from TestState: " + count);
			}
		});
	}
}

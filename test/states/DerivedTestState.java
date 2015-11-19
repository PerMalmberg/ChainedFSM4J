package states;

import chainedfsm.EnterChain;
import chainedfsm.FSM;
import chainedfsm.LeaveChain;
import chainedfsm.interfaces.IEnter;
import chainedfsm.interfaces.ILeave;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class DerivedTestState extends TestState {

	public DerivedTestState(FSM<TestBaseState> fsm) {
		super(fsm);

		new EnterChain<DerivedTestState>(this, new IEnter() {
			@Override
			public void enter() {
				// We can access private fields of DerivedTestState from here
				++count;
				System.out.println("enter: Hello from DerivedTestState:" + count);

			}
		});

//      Java8 syntax with Lambda
//		new EnterChain<DerivedTestState>(this, () -> {
//			// We can access private fields of DerivedTestState from here
//			++count;
//			System.out.println("enter: Hello from DerivedTestState:" + count);
//
//		});

		new LeaveChain<TestState>(this, new ILeave() {
			@Override
			public void leave() {
				// We can access private fields of DerivedTestState from here
				--count;
				System.out.println("leave: Goodbye from DerivedTestState: " + count);
			}
		});
	}
}

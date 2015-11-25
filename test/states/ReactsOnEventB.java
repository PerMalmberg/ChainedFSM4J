package states;

import chainedfsm.EnterChain;
import chainedfsm.FSM;
import chainedfsm.LeaveChain;
import chainedfsm.interfaces.IEnter;
import chainedfsm.interfaces.ILeave;
import events.EventB;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class ReactsOnEventB extends TestBaseState {

	public ReactsOnEventB(FSM<TestBaseState> fsm) {
		super(fsm);

		new EnterChain<ReactsOnEventB>(this, new IEnter() {
			@Override
			public void enter() {
				// We can access private fields of ReactsOnEventB from here
				++count;
				System.out.println("enter: Hello from ReactsOnEventB: " + count);

			}
		});

//      Java8 syntax with Lambda
//		new EnterChain<ReactsOnEventB>(this, () -> {
//			// We can access private fields of ReactsOnEventB from here
//			++count;
//			System.out.println("enter: Hello from ReactsOnEventB:" + count);
//
//		});

		new LeaveChain<ReactsOnEventB>(this, new ILeave() {
			@Override
			public void leave() {
				// We can access private fields of ReactsOnEventB from here
				--count;
				System.out.println("leave: Goodbye from ReactsOnEventB: " + count);
			}
		});
	}

	@Override
	public void accept(EventB b) {
		b.methodInB();
		getFsm().setState(new ReactsOnEventA(getFsm()));
	}
}

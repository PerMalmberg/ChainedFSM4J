import chainedfsm.EnterChain;
import chainedfsm.LeaveChain;
import chainedfsm.interfaces.IEnter;
import chainedfsm.interfaces.ILeave;
import events.EventA;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class ReactsOnEventA extends TestBaseState {

	public ReactsOnEventA(chainedfsm.FSM<TestBaseState> fsm) {
		super(fsm);

		new EnterChain<ReactsOnEventA>(this, new IEnter() {
			@Override
			public void enter() {
				// We can access private fields of ReactsOnEventA from here
				++count;
				System.out.println("enter: Hello from ReactsOnEventA: " + count);
			}
		});

		new LeaveChain<ReactsOnEventA>(this, new ILeave() {
			@Override
			public void leave() {
				// We can access private fields of ReactsOnEventA from here
				--count;
				System.out.println("leave: Goodbye from ReactsOnEventA: " + count);
			}
		});
	}

	@Override
	public void accept(EventA a) {
		a.methodInA();
		getFsm().setState(new ReactsOnEventB(getFsm()));
	}
}

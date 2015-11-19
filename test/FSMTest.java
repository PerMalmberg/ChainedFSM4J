import states.DerivedTestState;
import states.TestBaseState;
import states.TestState;

import static org.junit.Assert.assertEquals;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class FSMTest {

	private chainedfsm.FSM<TestBaseState> fsm = new chainedfsm.FSM<TestBaseState>();

	@org.junit.Before
	public void setUp() throws Exception {

	}

	@org.junit.After
	public void tearDown() throws Exception {

	}

	@org.junit.Test
	public void testSetState() throws Exception {
		fsm.setState(new TestState(fsm));
		assertEquals(1, fsm.getCurrentState().getCount());
		fsm.setState(new DerivedTestState(fsm));
		assertEquals(2, fsm.getCurrentState().getCount());
		fsm.setState(new TestState(fsm));
		assertEquals(1, fsm.getCurrentState().getCount());
	}
}
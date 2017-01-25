import events.EventA;
import events.EventB;
import states.ReactsOnEventA;
import states.ReactsOnEventB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class FSMTest {

	private FsmExample fsm = new FsmExample();

	@org.junit.Before
	public void setUp() throws Exception {

	}

	@org.junit.After
	public void tearDown() throws Exception {

	}

	@org.junit.Test
	public void testSetState() throws Exception {
		fsm.setState(new ReactsOnEventA(fsm));
		assertEquals(1, fsm.getCurrentState().getCount());
		fsm.setState(new ReactsOnEventB(fsm));
		assertEquals(1, fsm.getCurrentState().getCount());
		fsm.setState(new ReactsOnEventA(fsm));
		assertEquals(1, fsm.getCurrentState().getCount());
	}

	@org.junit.Test
	public void testEventA() throws Exception {
		fsm.setState(new ReactsOnEventA(fsm));

		fsm.event(new EventA("Some data carried by the event"));
		assertTrue(fsm.getCurrentState() instanceof ReactsOnEventB);
		fsm.event(new EventB());
		assertTrue(fsm.getCurrentState() instanceof ReactsOnEventA);
		fsm.event(new EventA("Some other data carried by the event"));
		fsm.event(new EventA("Won't change state because of this event"));
		assertTrue(fsm.getCurrentState() instanceof ReactsOnEventB);

	}
}
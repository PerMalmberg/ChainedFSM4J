package chainedfsm;

import chainedfsm.interfaces.IEnter;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class EnterChain<T extends EnterLeaveState> {
	public EnterChain(T base, IEnter initializer) {
		base.registerEnter(initializer);
	}
}

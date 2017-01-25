package chainedfsm;

import chainedfsm.interfaces.ILeave;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public class LeaveChain<T extends EnterLeaveState> {
	public LeaveChain(T base, ILeave deInitializer) {
		base.registerLeave(deInitializer);
	}
}

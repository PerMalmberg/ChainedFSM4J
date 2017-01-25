package chainedfsm;

import chainedfsm.interfaces.IEnter;
import chainedfsm.interfaces.ILeave;

import java.util.ArrayList;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public abstract class EnterLeaveState {
	private ArrayList<IEnter> myEnter = new ArrayList<IEnter>();
	private ArrayList<ILeave> myLeave = new ArrayList<ILeave>();

	/**
	 * Calls the enter chain
	 * Access: Package-local
	 */
	void doEnter() {
		for (IEnter initializer : myEnter) {
			initializer.enter();
		}
	}

	/**
	 * Calls the leave chain
	 * Access: Package-local
	 */
	void doLeave() {
		for (ILeave deInitializer : myLeave) {
			deInitializer.leave();
		}
	}

	/**
	 * Registers an enter chain
	 *
	 * @param initializer The initializer
	 */
	void registerEnter(IEnter initializer) {
		myEnter.add(initializer);
	}

	/**
	 * Registers a leave chain
	 *
	 * @param deInitializer
	 */
	void registerLeave(ILeave deInitializer) {
		// Insert first, as we want the reverse call order as for enter()
		myLeave.add(0, deInitializer);
	}
}

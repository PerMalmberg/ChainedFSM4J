package chainedfsm.interfaces;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public interface ILeave {
	/**
	 * Called before the next state is set.
	 * Always called before the next state's enter() is called.
	 */
	void leave();
}

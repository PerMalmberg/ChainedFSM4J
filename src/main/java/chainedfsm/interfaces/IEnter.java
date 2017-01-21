package chainedfsm.interfaces;

/**
 * Created by Per Malmberg on 2015-11-19.
 */
public interface IEnter {
	/**
	 * Called after the new state is set.
	 * Always called after the previous state's leave() has been called.
	 */
	void enter();

}

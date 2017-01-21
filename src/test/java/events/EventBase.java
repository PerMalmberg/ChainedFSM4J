package events;

/**
 * Created by Per Malmberg on 2015-11-23.
 */
public abstract class EventBase {
	public abstract void Visit(IEventListener listener);


}

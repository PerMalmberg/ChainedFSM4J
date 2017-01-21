package events;

/**
 * Created by Per Malmberg on 2015-11-23.
 */
public interface IEventListener {
	void accept(EventA a);

	void accept(EventB b);
}

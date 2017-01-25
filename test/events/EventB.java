package events;

/**
 * Created by Per Malmberg on 2015-11-23.
 */
public class EventB extends EventBase {
	@Override
	public void Visit(IEventListener listener) {
		listener.accept(this);
	}

	public void methodInB() {
		System.out.println("EventB");
	}
}

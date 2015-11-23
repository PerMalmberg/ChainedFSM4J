package events;

/**
 * Created by Per Malmberg on 2015-11-23.
 */
public class EventA extends EventBase {

	private final String myData;

	public EventA(String data) {
		myData = data;
	}

	@Override
	public void Visit(IEventListener listener) {
		listener.accept(this);
	}

	public void methodInA() {
		System.out.println("EventA: " + myData);
	}
}

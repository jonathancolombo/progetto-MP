package project.mp.book;

public class UserObserver implements BookObserver {

	private EventBook event;

	@Override
	public void update(EventBook event) {
		this.event = event;
	}

	public EventBook getEvent() {
		return event;
	}

}

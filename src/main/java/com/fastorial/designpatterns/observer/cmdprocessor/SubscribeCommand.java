package com.fastorial.designpatterns.observer.cmdprocessor;

import com.fastorial.designpatterns.observer.IPublisher;
import com.fastorial.designpatterns.observer.ISubscriber;
import com.fastorial.designpatterns.observer.MailSubscriber;
import com.fastorial.designpatterns.observer.PushSubscriber;

//      0      1          2            3
// SUBSCRIBE EMAIL shibin@gmail.com fastorial
public class SubscribeCommand implements ICommand {

	private final IPublisher publisher;

	private final String destinationId;
	private final String channelName;
	private final ISubscriber subscriber;

	public SubscribeCommand(String cmd, IPublisher publisher) {
		super();
		this.publisher = publisher;

		String[] commands = cmd.split(" ");
		this.destinationId = commands[2];
		this.channelName = commands[3];
		switch (commands[1]) {
		case "EMAIL":
			this.subscriber = new MailSubscriber(destinationId);
			break;
		case "PUSH":
			this.subscriber = new PushSubscriber(destinationId);
			break;
		default:
			throw new IllegalArgumentException("Invalid subscriberType: " + commands[1]);
		}
	}

	@Override
	public void execute() {
		publisher.subscribe(channelName, subscriber);
	}

}

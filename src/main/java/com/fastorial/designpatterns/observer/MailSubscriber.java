package com.fastorial.designpatterns.observer;

import com.fastorial.designpatterns.observer.enums.ContentType;
import com.fastorial.designpatterns.observer.enums.SubscriberType;

// [SubsriberType] destinationId "published" contentType contentTitle
// [EMAIL] shibin@gmail.com published VIDEO Observer design pattern
public class MailSubscriber implements ISubscriber {

	private final String destinationId; // e-mail ID

	public MailSubscriber(String destinationId) {
		super();
		this.destinationId = destinationId;
	}

	@Override
	public void sendNotification(String contentTitle, ContentType contentType) {
		System.out.println(
				"[" + getSubscriberType() + "] " + destinationId + " published " + contentType + " " + contentTitle);
	}

	public SubscriberType getSubscriberType() {
		return SubscriberType.MAIL;
	}

	public String getDestinationId() {
		return destinationId;
	}

}

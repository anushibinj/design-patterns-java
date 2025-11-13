package com.fastorial.designpatterns.observer;

import com.fastorial.designpatterns.observer.enums.ContentType;
import com.fastorial.designpatterns.observer.enums.SubscriberType;

public interface ISubscriber {

	public void sendNotification(String contentTitle, ContentType contentType);

	public SubscriberType getSubscriberType();

	public String getDestinationId();
}

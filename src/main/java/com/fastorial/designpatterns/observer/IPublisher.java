package com.fastorial.designpatterns.observer;

import com.fastorial.designpatterns.observer.enums.ContentType;

public interface IPublisher {
	public void subscribe(String channelName, ISubscriber subscriber);

	public void unSubscribe(String channelName, ISubscriber subscriber);

	public void notifySubscribers(String channelName, String contentTitle, ContentType contentType);
}

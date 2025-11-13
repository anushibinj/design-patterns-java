package com.fastorial.designpatterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fastorial.designpatterns.observer.enums.ContentType;

public class YouTube implements IPublisher {

	// TODO: Homework - try to do a List<Channel> and store the subscribers inside
	// each Channel
	Map<String, List<ISubscriber>> channelMap = new HashMap<>();

	@Override
	public void subscribe(String channelName, ISubscriber subscriber) {
		List<ISubscriber> existingSubscribers = channelMap.getOrDefault(channelName, new ArrayList<>());

		existingSubscribers.add(subscriber);

		channelMap.put(channelName, existingSubscribers);

		System.out.println("Subscriber added: " + subscriber.getSubscriberType() + " " + subscriber.getDestinationId()
				+ " -> channel " + channelName);
	}

	@Override
	public void unSubscribe(String channelName, ISubscriber subscriber) {
		List<ISubscriber> existingSubscribers = channelMap.getOrDefault(channelName, new ArrayList<>());

		existingSubscribers.remove(subscriber);

		channelMap.put(channelName, existingSubscribers);
	}

	@Override
	public void notifySubscribers(String channelName, String contentTitle, ContentType contentType) {
		List<ISubscriber> existingSubscribers = channelMap.get(channelName);

		if (existingSubscribers == null) {
			System.err.println("No subscribers for channel ai-videos");
			return;
		}

		for (ISubscriber sub : existingSubscribers) {
			sub.sendNotification(contentTitle, contentType);
		}
	}

}

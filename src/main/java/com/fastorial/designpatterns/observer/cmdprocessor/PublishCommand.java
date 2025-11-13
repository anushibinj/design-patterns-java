package com.fastorial.designpatterns.observer.cmdprocessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fastorial.designpatterns.observer.IPublisher;
import com.fastorial.designpatterns.observer.enums.ContentType;

// PUBLISH fastorial "Observer design pattern" VIDEO
public class PublishCommand implements ICommand {

	private final String channelName;
	private final String contentTitle;
	private final ContentType contentType;

	private final IPublisher publisher;

	public PublishCommand(String cmd, IPublisher publisher) {
		super();
		this.publisher = publisher;

		// We are using this pattern matcher to handle the weird quotes and spaces in
		// the content title of the command
		Pattern pattern = Pattern.compile("PUBLISH\\s+(\\S+)\\s+\"([^\"]+)\"\\s+(\\S+)");
		Matcher matcher = pattern.matcher(cmd);
		matcher.find();

		this.channelName = matcher.group(1);
		this.contentTitle = matcher.group(2);
		String contentTypeAsString = matcher.group(3);

		switch (contentTypeAsString) {
		case "VIDEO":
			this.contentType = ContentType.VIDEO;
			break;
		case "POST":
			this.contentType = ContentType.POST;
			break;
		default:
			throw new IllegalArgumentException("Invalid contentType: " + contentTypeAsString);
		}

	}

	@Override
	public void execute() {
		publisher.notifySubscribers(channelName, contentTitle, contentType);
	}

}

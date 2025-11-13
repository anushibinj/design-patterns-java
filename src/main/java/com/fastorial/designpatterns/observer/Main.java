package com.fastorial.designpatterns.observer;

import java.util.Scanner;

import com.fastorial.designpatterns.observer.cmdprocessor.ExitCommand;
import com.fastorial.designpatterns.observer.cmdprocessor.ICommand;
import com.fastorial.designpatterns.observer.cmdprocessor.PublishCommand;
import com.fastorial.designpatterns.observer.cmdprocessor.SubscribeCommand;

public class Main {
	public static void main(String[] args) {
		Scanner in = null;

		try {
			in = new Scanner(System.in);

			IPublisher youtube = new YouTube();

			while (true) {
				String cmd = in.nextLine();
				ICommand commandExecutor;
				if (cmd.startsWith("SUBSCRIBE")) {
					commandExecutor = new SubscribeCommand(cmd, youtube);
				} else if (cmd.startsWith("PUBLISH")) {
					commandExecutor = new PublishCommand(cmd, youtube);
				} else if (cmd.startsWith("EXIT")) {
					commandExecutor = new ExitCommand();
				} else {
					System.out.println("Invalid command. Try again");
					continue;
				}
				commandExecutor.execute();
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}

	}

	/**
	 * // SUBSCRIBE EMAIL shibin@gmail.com fastorial IPublisher youtube = new
	 * YouTube();
	 * 
	 * ISubscriber shibinMail = new MailSubscriber("shibin@gmail.com");
	 * 
	 * youtube.subscribe("fastorial", shibinMail);
	 * 
	 * // SUBSCRIBE PUSH shibin-iPhone fastorial ISubscriber shibinPush = new
	 * PushSubscriber("shibin-iPhone"); youtube.subscribe("fastorial", shibinPush);
	 * 
	 * // PUBLISH fastorial "Observer design pattern" VIDEO
	 * youtube.notifySubscribers("fastorial", "Observer design pattern",
	 * ContentType.VIDEO);
	 * 
	 * // PUBLISH ai-videos "Brainrot Part 1" POST
	 * youtube.notifySubscribers("ai-videos", "Brainrot Part 1", ContentType.POST);
	 */
}

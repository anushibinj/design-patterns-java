package com.fastorial.designpatterns.observer.cmdprocessor;

public class ExitCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("Goodbye!");
		System.exit(0);
	}

}

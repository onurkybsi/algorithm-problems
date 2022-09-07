package org.kybprototyping;

public enum ConsoleUtils {
	INSTANCE;

	public void info(Object message) {
		System.console().writer().println(message);
	}

	public void error(Object message) {
		System.console().writer().println(message);
	}

	public void clearConsole() {
		System.console().writer().print("\033[H\033[2J");
		System.console().flush();
	}
}

package org.kybprototyping;

public enum SimpleLogger {
	INSTANCE;

	public void logInfo(Object message) {
		System.console().writer().println(message);
	}
}

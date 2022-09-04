package org.kybprototyping;

@SuppressWarnings("java:S106")
public enum SimpleLogger {
	INSTANCE;

	public void logInfo(Object message) {
		System.out.println(message);
	}
}

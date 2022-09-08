package org.kybprototyping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public enum ConsoleUtils {
	INSTANCE;

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_RED = "\u001B[31m";

	private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public void info(Object message) {
		System.console().writer().println(message);
	}

	public void infoGreen(Object message) {
		colorfulInfo(message, ANSI_GREEN);
	}

	public String toGreen(Object message) {
		return toColorful(message, ANSI_GREEN);
	}

	private void colorfulInfo(Object message, String color) {
		System.console().writer().println(String.format("%s%s%s", color, message, ANSI_RESET));
	}

	private String toColorful(Object message, String color) {
		return String.format("%s%s%s", color, message, ANSI_RESET);
	}

	public void infoYellow(Object message) {
		colorfulInfo(message, ANSI_YELLOW);
	}

	public String toYellow(Object message) {
		return toColorful(message, ANSI_YELLOW);
	}

	public void infoRed(Object message) {
		colorfulInfo(message, ANSI_RED);
	}

	public String toRed(Object message) {
		return toColorful(message, ANSI_RED);
	}

	public void error(Object message) {
		System.console().writer().println(message);
	}

	public void clearConsole() {
		System.console().writer().print("\033[H\033[2J");
		System.console().flush();
	}

	public String toPrettyString(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			error(e);
			throw new KybPrototypingException("pretty strin couldn't be built!", e);
		}
	}
}

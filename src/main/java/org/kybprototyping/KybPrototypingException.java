package org.kybprototyping;

/**
 * My super custom runtime exception
 */
public class KybPrototypingException extends RuntimeException {
	public KybPrototypingException(String message) {
		super(message);
	}

	public KybPrototypingException(String message, Throwable cause) {
		super(message, cause);
	}
}

package org.kybprototyping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("java:S112")
public class BootstrapHelper {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final ProblemsArgs problemArgs = buildProblemArgs();

	private BootstrapHelper() {
		throw new UnsupportedOperationException("This class is stateless!");
	}

	private static ProblemsArgs buildProblemArgs() {
		try {
			InputStream problemArgsInputStream = Main.class.getClassLoader()
					.getResourceAsStream("problem-args.json");
			return objectMapper.readValue(problemArgsInputStream, ProblemsArgs.class);
		} catch (IOException e) {
			throw new RuntimeException("Bootstrapping unsuccessful!", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getProblemArgs(Class<T> problemArgsType) {
		try {
			return (List<T>) ProblemsArgs.class
					.getMethod(String.format("get%s", problemArgsType.getSimpleName()))
					.invoke(problemArgs);
		} catch (Exception e) {
			throw new RuntimeException("Getting problem args unsuccessful!", e);
		}
	}
}

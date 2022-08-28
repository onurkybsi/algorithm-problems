package org.kybprototyping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "java:S112" })
public class BootstrapHelper {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	private static final Map<String, JsonNode> problemArgs = buildProblemArgs();

	private BootstrapHelper() {
		throw new UnsupportedOperationException("This class is stateless!");
	}

	private static Map<String, JsonNode> buildProblemArgs() {
		try {
			InputStream problemArgsInputStream = Main.class.getClassLoader()
					.getResourceAsStream("problem-args.json");
			return objectMapper.readValue(problemArgsInputStream,
					objectMapper.getTypeFactory().constructType(new TypeReference<Map<String, JsonNode>>() {
					}));
			// return objectMapper.readTree(problemArgsInputStream);
		} catch (IOException e) {
			throw new RuntimeException("Bootstrapping unsuccessful!", e);
		}
	}

	public static <T> List<T> getProblemArgs(String problemName) {
		try {
			return objectMapper.convertValue(problemArgs.get(problemName),
					new TypeReference<List<T>>() {
					});
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Bootstrapping unsuccessful!", e);
		}
	}
}

package org.kybprototyping.problems;

import java.util.List;

/**
 * Represents an algorithm problem
 */
public interface AlgorithmProblem<T> {
	/**
	 * Returns problem name
	 *
	 * @return problem name
	 */
	String getName();

	/**
	 * Returns the description link of the problem
	 * 
	 * @return the description link of the problem
	 */
	String getDescriptionLink();

	/**
	 * Returns entered arguments for the problem
	 *
	 * @return entered arguments
	 */
	List<T> getProblemArgs();

	/**
	 * Runs and prints the developed algorithm result by the choosen args
	 *
	 * @param argsOrder order number of the available args
	 */
	void runSolution(int argsOrder);
}

package ca.uqam.mgl7361.a2011.gamma.formats;

import java.lang.reflect.Method;
import java.util.Map.Entry;
import ca.uqam.mgl7361.a2011.gamma.Execution;

public class PlainTextFormat implements Format {

	public String applyFormat(Execution execution) {
		StringBuilder formattedExecution = new StringBuilder();
		formattedExecution.append("Execution time : ");
		formattedExecution.append(execution.getExecutionTime() + "\n");
		formattedExecution.append("Number of tests : ");
		formattedExecution.append(execution.getNumberOfTests() + "\n");
		formattedExecution.append("Number of failures : ");
		formattedExecution.append(execution.getNumberOfFailures() + "\n\n");
		formattedExecution.append("Detailed execution results : \n");
		formattedExecution.append("---------------------------- \n");
		for (Entry<Method, Execution.TestResult> entry : execution.getTestResults().entrySet()) {
			formattedExecution.append(getFormattedEntry(entry));
		}
		formattedExecution.append("\n");
		return formattedExecution.toString();
	}
	
	private String getFormattedEntry(Entry<Method, Execution.TestResult> entry) {
		StringBuilder formattedEntry = new StringBuilder();
		formattedEntry.append(entry.getKey().getDeclaringClass().getName());
		formattedEntry.append(".");
		formattedEntry.append(entry.getKey().getName());
		formattedEntry.append(" - ");
		formattedEntry.append(entry.getValue().toString());
		formattedEntry.append("\n");
		return formattedEntry.toString();
	}
}

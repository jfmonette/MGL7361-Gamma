package ca.uqam.mgl7361.a2011.gamma.formats;

import ca.uqam.mgl7361.a2011.gamma.executions.*;

public class PlainTextFormat implements Format {
	
	public String applyFormat(Executions executions) {
		StringBuilder formattedExecutions = new StringBuilder();
		formattedExecutions.append(executions.getName());
		formattedExecutions.append(" Executions : ");
		formattedExecutions.append(executions.getNumberOfExecutions());
		formattedExecutions.append(" Failures : ");
		formattedExecutions.append(executions.getNumberOfFailures());
		formattedExecutions.append(" Finished after : ");
		formattedExecutions.append(executions.getExecutionTime());
		formattedExecutions.append(" seconds");
		formattedExecutions.append("\n");
		formattedExecutions.append(getExecutionDetails(executions));
		return formattedExecutions.toString();
	}

	private String getExecutionDetails(Executions executions) {
		StringBuilder executionsDetails = new StringBuilder();
		for(Execution execution : executions.getExecutions()) {
			executionsDetails.append(execution.getName());
			executionsDetails.append(" - ");
			executionsDetails.append(execution.getResult().toString());
			executionsDetails.append("\n");
		}
		return executionsDetails.toString();
	}

	public String getFileExtension() {
		return "txt";
	}
}

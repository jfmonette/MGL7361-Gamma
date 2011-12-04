package ca.uqam.mgl7361.a2011.gamma.executions;

import java.util.*;

import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class ExecutionsCollection {
	private String name;
	private Collection<Execution> executions = new ArrayList<Execution>();
	
	public ExecutionsCollection(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void add(Execution execution) {
		this.executions.add(execution);
	}
	
	public Collection<Execution> getExecutions() {
		return this.executions;
	}
	
	public long getExecutionTime() {
		long executionTime = 0;
		for (Execution execution : executions) {
			executionTime += execution.getExecutionTime();
		}
		return executionTime;
	}
	
	public int getNumberOfExecutions() {
		return this.getExecutions().size();
	}
	
	public int getNumberOfFailures() {
		int numberOfFailures = 0;
		for(Execution execution : executions) {
			if(execution.getResult().equals(Result.Failed)) {
				numberOfFailures++;
			}
		}
		return numberOfFailures;
	}
}

package ca.uqam.mgl7361.a2011.gamma.executions;

import java.util.*;

import ca.uqam.mgl7361.a2011.gamma.executions.Execution.Result;

public class Executions {
	private String name;
	private Date executionsDate = new Date();
	private Collection<Execution> executions = new ArrayList<Execution>();
	
	public Executions(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getExecutionsDate() {
		return executionsDate;
	}

	public void add(Execution execution) {
		this.executions.add(execution);
	}
	
	public Collection<Execution> getExecutions() {
		return this.executions;
	}
	
	public double getExecutionTime() {
		long executionTime = 0;
		for (Execution execution : executions) {
			executionTime += execution.getExecutionTime();
		}
		return (double)executionTime / 1000000000.0;
	}
	
	public double getNumberOfExecutions() {
		return this.getExecutions().size();
	}
	
	public double getNumberOfFailures() {
		double numberOfFailures = 0;
		for(Execution execution : executions) {
			if(execution.getResult().equals(Result.Failed)) {
				numberOfFailures++;
			}
		}
		return numberOfFailures;
	}
}

package ca.uqam.mgl7361.a2011.gamma.executions;

public class Execution {
	private long executionTime;
	private String name;
	private Result result;
	
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public long getExecutionTime() {
		return executionTime;
	}
	public String getName() {
		return name;
	}
	public Result getResult() {
		return result;
	}
	public enum Result {
		Successful, Failed
	}
}

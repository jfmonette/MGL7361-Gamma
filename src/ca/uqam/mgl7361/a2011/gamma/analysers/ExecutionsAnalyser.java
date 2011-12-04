package ca.uqam.mgl7361.a2011.gamma.analysers;

import java.util.*;

import ca.uqam.mgl7361.a2011.gamma.executions.*;

public class ExecutionsAnalyser {
	private StatisticsProvider stats = new StatisticsProvider();
	Collection<Double> executionTimes = new ArrayList<Double>();
	Collection<Double> numberOfExecutionsByDay = new ArrayList<Double>();
	Collection<Double> turnAroundTimes = new ArrayList<Double>();
	
	public StatisticalAnalysis analyse(Collection<Executions> executionsCollection) {
		fillExecutionTimes(executionsCollection);
		fillNumberOfExecutionsByDay(executionsCollection);
		fillTurnAroundTimes(executionsCollection);
		
		StatisticalAnalysis analysis = new StatisticalAnalysis();
		
		return analysis;
	}

	private void fillExecutionTimes(Collection<Executions> executionsCollection) {
		for (Executions executions : executionsCollection) {
			executionTimes.add(executions.getExecutionTime());
		}
		
	}
	
	
	/**
	 * This is an unmaintainable method written at 2:30 am while drinking Griffon Rousse.
	 * The author suggests you open a cold one before reading this code.
	 */
	private void fillNumberOfExecutionsByDay(Collection<Executions> executionsCollection) {
		Map<Date, Collection<Double>> executionsByDay = new HashMap<Date, Collection<Double>>();
		for (Executions executions : executionsCollection) {
			Date executionsDate = getTruncatedDate(executions.getExecutionsDate());
			if (executionsByDay.containsKey(executionsDate)) {
				Collection<Double> executionsTimes = executionsByDay.get(executionsDate);
				executionsTimes.add(executions.getExecutionTime());
			}
			else {
				Collection<Double> executionsTimes = new ArrayList<Double>();
				executionsTimes.add(executions.getExecutionTime());
				executionsByDay.put(executionsDate, executionsTimes);
			}
		}
		
		for (Map.Entry<Date, Collection<Double>> entry : executionsByDay.entrySet()) {
			double numberOfExecutionsByDay = 0;
			for (Double executions : entry.getValue()) {
				numberOfExecutionsByDay += executions;
			}
			this.numberOfExecutionsByDay.add(numberOfExecutionsByDay);
		}	
	}
	
	private Date getTruncatedDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	private void fillTurnAroundTimes(Collection<Executions> executionsCollection) {
		
		
	}

}

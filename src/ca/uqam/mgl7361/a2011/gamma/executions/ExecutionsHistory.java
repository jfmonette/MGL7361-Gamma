package ca.uqam.mgl7361.a2011.gamma.executions;

import java.util.*;
import java.util.Map.Entry;

public class ExecutionsHistory {
	private Collection<Executions> executionsCollection = new ArrayList<Executions>();
	
	public void add(Executions executions) {
		executionsCollection.add(executions);
	}
	
	public Collection<Double> getExecutionTimes() {
		Collection<Double> executionTimes = new ArrayList<Double>();
		for (Executions executions : executionsCollection) {
			executionTimes.add(executions.getExecutionTime());
		}
		return executionTimes;
	}
	
	public Collection<Double> getNumberOfExecutionsByDay() {
		Collection<Double> executionsByDay = new ArrayList<Double>();
		Collection<Date> executionsDates = getExecutionsDates();
		for (Date day : executionsDates) {
			executionsByDay.add(getNumberOfExecutionsForDate(day));
		}
		
		return executionsByDay;
	}
	
	public Collection<Double> getTurnAroundTimes() {
		Collection<Double> turnAroundTimes = new ArrayList<Double>();
		SortedMap<Date, Boolean> executionsOutcomesByDate = getExecutionsOutcomesByDate();
		Queue<Entry<Date, Boolean>> queue = new LinkedList<Entry<Date, Boolean>>();
		
		for (Entry<Date, Boolean> entry : executionsOutcomesByDate.entrySet()) {
			queue.add(entry);		
		}
		
		Entry<Date, Boolean> currentEntry = queue.poll();
		Entry<Date, Boolean> nextEntry = queue.poll();
		while (currentEntry != null && nextEntry != null) {
			if (currentEntry.getValue() == true) {
				currentEntry = nextEntry;
			}
			else {
				if (nextEntry != null && nextEntry.getValue() == true) {
					turnAroundTimes.add((double)(nextEntry.getKey().getTime() - currentEntry.getKey().getTime()));
					currentEntry = queue.poll();
				}
			}
			nextEntry = queue.poll();
		}
		
		return turnAroundTimes;
	}

	private SortedMap<Date, Boolean> getExecutionsOutcomesByDate() {
		SortedMap<Date, Boolean> executionsOutcomesByDate = new TreeMap<Date, Boolean>();
		for (Executions executions : executionsCollection) {
			if (executions.getNumberOfFailures() == 0) {
				executionsOutcomesByDate.put(executions.getExecutionsDate(), true);
			}
			else {
				executionsOutcomesByDate.put(executions.getExecutionsDate(), false);
			}
		}
		return executionsOutcomesByDate;
	}

	private Collection<Date> getExecutionsDates() {
		Collection<Date> executionDates = new ArrayList<Date>();
		Calendar calendar = getCalendarTruncatedToDays();
		for (Executions executions : executionsCollection) {
			executionDates.add(executions.getExecutionsDate(calendar));
		}
		return executionDates;
	}
	
	private Calendar getCalendarTruncatedToDays() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	private Double getNumberOfExecutionsForDate(Date day) {
		double numberOfExecutions = 0;
		Calendar calendar = getCalendarTruncatedToDays();
		for (Executions executions : executionsCollection) {
			if (executions.getExecutionsDate(calendar).equals(day)) {
				numberOfExecutions += executions.getNumberOfExecutions();
			}
		}
		return numberOfExecutions;
	}
}

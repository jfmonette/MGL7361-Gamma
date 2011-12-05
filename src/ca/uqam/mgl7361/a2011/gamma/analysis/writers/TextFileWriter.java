package ca.uqam.mgl7361.a2011.gamma.analysis.writers;

import java.io.*;
import java.util.Collection;
import ca.uqam.mgl7361.a2011.gamma.analysis.StatisticalAnalysis;
import ca.uqam.mgl7361.a2011.gamma.analysis.formats.*;

public class TextFileWriter implements Writer {
	private String fileName;
	
	public TextFileWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void write(Collection<StatisticalAnalysis> analysises, Format format) {
		String executionStringRepresentation = format.applyFormat(analysises);
		try {
			FileWriter fileStream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fileStream);
			out.write(executionStringRepresentation);
			out.close();
		}
		catch (IOException ex) {
			System.out.print("Unable to write to file. Call Superman.");
		}	
	}

}

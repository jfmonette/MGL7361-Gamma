package ca.uqam.mgl7361.a2011.gamma.writers;

import java.io.*;

import ca.uqam.mgl7361.a2011.gamma.Execution;
import ca.uqam.mgl7361.a2011.gamma.formats.Format;

public class TextFileWriter implements Writer {
	private String fileName;
	
	public TextFileWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void write(Execution execution, Format format) {
		String executionStringRepresentation = format.applyFormat(execution);
		try {
			FileWriter fileStream = new FileWriter(fileName, true);
			BufferedWriter out = new BufferedWriter(fileStream);
			out.write(executionStringRepresentation);
			out.close();
		}
		catch (IOException ex) {
			System.out.print("Unable to write to file. Call Superman.");
		}	
	}

}

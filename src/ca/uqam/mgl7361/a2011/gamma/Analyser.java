package ca.uqam.mgl7361.a2011.gamma;

import java.io.FileReader;
import java.util.*;
import ca.uqam.mgl7361.a2011.gamma.analysis.*;
import ca.uqam.mgl7361.a2011.gamma.analysis.formats.*;
import ca.uqam.mgl7361.a2011.gamma.analysis.writers.*;
import ca.uqam.mgl7361.a2011.gamma.executions.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Analyser {

	public static void main(String[] args) {
		FileReader fileReader;
		XStream xstream = new XStream(new DomDriver());
		ExecutionsHistory history = new ExecutionsHistory();
		for (String arg : args) {
			try {
	        	fileReader = new FileReader(arg);
	        	Executions executions = (Executions)xstream.fromXML(fileReader);
	        	history.add(executions);
	        	fileReader.close();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		ExecutionsAnalyser analyser = new ExecutionsAnalyser();
		Collection<StatisticalAnalysis> analysises = analyser.analyse(history);
		Format format = new HTMLFormat();
		Writer writer = new TextFileWriter("Analysis." + format.getFileExtention());
		writer.write(analysises, format);
	}
}

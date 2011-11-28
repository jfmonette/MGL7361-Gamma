package ca.uqam.mgl7361.a2011.gamma;

import ca.uqam.mgl7361.a2011.gamma.formats.*;
import ca.uqam.mgl7361.a2011.gamma.writers.*;
import jargs.gnu.CmdLineParser;

public class Gamma {
	
	static CmdLineParser commandLineParser = new CmdLineParser();
	static CmdLineParser.Option outputFileNameOption;
	static CmdLineParser.Option consoleOutputEnabledOption;
	static CmdLineParser.Option xmlOutputEnabledOption;
	
	public static void main(String[] args) {
		parseCommandLineArguments(args);
		String fileName = (String)commandLineParser.getOptionValue(outputFileNameOption, "Execution.txt");
		boolean xmlFormatEnabled = (Boolean)commandLineParser.getOptionValue(xmlOutputEnabledOption, Boolean.FALSE);
		boolean consoleOutputEnabled = (Boolean)commandLineParser.getOptionValue(consoleOutputEnabledOption, Boolean.FALSE);
			
		String[] testClassesNames = commandLineParser.getRemainingArgs();
		Execution execution = run(testClassesNames[0]);
		Writer writer = new TextFileWriter(fileName);
		Format format = new PlainTextFormat();
		if (xmlFormatEnabled)
			format = new XMLFormat();
		writer.write(execution, format);
		if (consoleOutputEnabled) {
			writer = new ConsoleWriter();
			writer.write(execution, format);
		}
	}

	private static Execution run(String testClassName) {
		Runner runner = new Runner();
		Execution execution = null;
		ClassLoader classLoader = Gamma.class.getClassLoader();
		Test test;
		try {
			test = (Test) classLoader.loadClass(testClassName).newInstance();
			execution = runner.run(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execution;

	}

	/*
	 * Si vous ajoutez de nouveaux paramètres à parser, il est bon de savoir que CmdLineParser
	 * ne permet qu'un seul appel de la fonction getOptionValue par option. Le deuxième appel lance
	 * une exception.
	 */
	private static void parseCommandLineArguments(String[] args) {
		try {
			consoleOutputEnabledOption = commandLineParser.addBooleanOption('c', "consoleOutput");
			xmlOutputEnabledOption = commandLineParser.addBooleanOption('x', "xml");
			outputFileNameOption = commandLineParser.addStringOption('f', "file");
			commandLineParser.parse(args);
		}
        catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(2);
        }
	}

	private static void printUsage() {
        System.err.println(
			"Usage: gamma.jar [-f,--file [file name]] [-c,--consoleOutput] [-x, --xml]");
    }

}

package ca.uqam.mgl7361.a2011.gamma.formats;

import java.util.Map.Entry;
import ca.uqam.mgl7361.a2011.gamma.Execution;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLFormat implements Format {

	public String applyFormat(Execution execution) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("execution", Execution.class);
		xstream.alias("test", Entry.class);
		xstream.alias("result", Execution.TestResult.class);
		String xml = xstream.toXML(execution);	
		return xml;
	}

}

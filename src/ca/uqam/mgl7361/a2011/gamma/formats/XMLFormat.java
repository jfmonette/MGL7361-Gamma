package ca.uqam.mgl7361.a2011.gamma.formats;

import ca.uqam.mgl7361.a2011.gamma.executions.ExecutionsCollection;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLFormat implements Format {

	public String applyFormat(ExecutionsCollection executions) {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(executions);	
		return xml;
	}

}

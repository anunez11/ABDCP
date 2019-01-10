package utilitario;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
@ApplicationScoped
public class Utilitario {
   
	private String XSD_FILE="C:\\Users\\Angel A\\Documents\\WS\\ABDCP\\src\\main\\webapp\\WEB-INF\\xsd\\elementoMsg.xsd";
	
	public Boolean validarMsg(String xmslMsg){
		 System.out.println("mensaje: "+xmslMsg);
	     try {
	    	 
	    	 System.out.println("NO paso nada ");
	            SchemaFactory factory = 
	                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(XSD_FILE));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new ByteArrayInputStream(xmslMsg.getBytes()) ));
	        } catch (IOException | SAXException e) {

	        	
	            return false;
	        }
	        return true;
	}
	
	
}

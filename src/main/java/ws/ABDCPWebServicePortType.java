package ws;

import javax.jws.WebService;

import entity.Mensaje;


@WebService(targetNamespace = "http://ws.inpac.telcordia.com")
public interface ABDCPWebServicePortType {
   
	String receiveMessage( String userID,
			 String password,
			 String xmlMsg,
			 byte[] attachedDoc);
	
}

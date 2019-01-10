package handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;



public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
	 
	 @Override
	 public Set<QName> getHeaders() {
	 return null;
	 }
	 
	 @Override
	 public void close(MessageContext context) {
	 }
	 
	 @Override
	 public boolean handleFault(SOAPMessageContext context) {
	  logToSystemOut(context);
	  return true;
	 }
	 
	 @Override
	 public boolean handleMessage(SOAPMessageContext context) {
	 logToSystemOut(context);
	  return true;
	 }
	 
	 private void logToSystemOut(SOAPMessageContext context) {
		 
		 Boolean esSalida = (Boolean) context
					.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				SOAPMessage soapMessage = context.getMessage();
				soapMessage.writeTo(baos);
				String a= esSalida ? "OUT" : "IN";
				System.out.println(a+" ==> "+baos.toString());
				//LOG.info("{}=[{}]", esSalida ? "OUT" : "IN",baos.toString());
				
			} catch (Exception ex) {
			    System.out.println(" Exception Handler  "+ex);
			}

			
		 
	  
	/*	 Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	 
	  try {
	  if (!outboundProperty.booleanValue()) {
	  
	   SOAPMessage message = smc.getMessage();
	  
	  System.out.println("Incoming message:");
	  ByteArrayOutputStream stream = new ByteArrayOutputStream();
	  message.writeTo(stream);
	  
	  System.out.println(stream.toString());
	  System.out.println("=====================================");                
	   }
	  }
	  catch (Exception e) {
	  System.out.println("Exception in handler: " + e);
	  }*/
	  }

	
	
}

package controller;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import pe.gtdo.logging.AbdcpLogger;
import utilitario.Utilitario;


@ApplicationScoped
public class ABDCPController {
  
	
	@Inject
	Utilitario utilitario;
	   
	@Inject
	AbdcpLogger LOG;
	
	public String getResultado(String userID, String password, String xmlMsg,
			byte[] attachedDoc){
		LOG.info("JAJAAJAJA");
		utilitario.validarMsg(xmlMsg);	
		
		return "ack";
		
	}
	
	
}

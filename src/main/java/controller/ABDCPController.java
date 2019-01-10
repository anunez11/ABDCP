package controller;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import utilitario.Utilitario;


@ApplicationScoped
public class ABDCPController {
  
	
	@Inject
	Utilitario utilitario;
	   
	public String getResultado(String userID, String password, String xmlMsg,
			byte[] attachedDoc){
		
		utilitario.validarMsg(xmlMsg);	
		
		return "ack";
		
	}
	
	
}

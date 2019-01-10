package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mensaje {
     
	private String userID;
	private String password;
	private String xmlMsg;
	private byte[] attachedDoc ;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getXmlMsg() {
		return xmlMsg;
	}
	public void setXmlMsg(String xmlMsg) {
		this.xmlMsg = xmlMsg;
	}
	public byte[] getAttachedDoc() {
		return attachedDoc;
	}
	public void setAttachedDoc(byte[] attachedDoc) {
		this.attachedDoc = attachedDoc;
	}
	
	
	
	
}

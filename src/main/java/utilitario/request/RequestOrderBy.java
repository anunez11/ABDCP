package utilitario.request;

public class RequestOrderBy {
	String field;
	Boolean isAsc = true;
	
	public RequestOrderBy() {
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Boolean getIsAsc() {
		return isAsc;
	}
	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}
}

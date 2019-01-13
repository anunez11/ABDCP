package utilitario.constante;





public enum FiltroSql {
   
	IN("in"),
	NOTIN("notin"),
	LIKE("like"),
	RLIKE("rlike"),
	LLIKE("llike"),
	BETWEEN("between"),
	BETWEENDATE("betweendate"),
	MAI("mai"),
	MEI("mei"),
	MA("ma"),
	ME("me"),	
	DIFERENTE("different"),
	DATE("date"),
	DEFECTO("");
	private final String value;	 
	private FiltroSql(String value) {
	       this.value = value;
	    }
		 public String VALUE() {
	       return value;
	    }
	
		  public static FiltroSql fromType( String idTipo ){
			  FiltroSql[] types = values();
			  FiltroSql id = null;
		        for ( int i = 0; i < types.length; i++ ){
		            id = types[i];
		            if ( idTipo.equals(id.value))return id;
		        }
		        return DEFECTO;
		    }	 
		 
		 
		 
		 
}

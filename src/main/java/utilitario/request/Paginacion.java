package utilitario.request;



public class Paginacion {

	Integer inicio;
	Integer fin;
	Integer pagina;
	Integer numeroPaginas;
	Integer registroPaginas;
	Integer totalRegistros;
	
	
	
	public Paginacion(Integer totalRegistros,Integer registroPaginas,Integer pagina) {
		super();
		this.totalRegistros = totalRegistros;
		this.registroPaginas = registroPaginas;
		this.pagina=pagina;
		
	}
	
	public Paginacion calcular(){		
		
		
		Integer n=0;
		if(this.registroPaginas > 0){
			n=this.totalRegistros/this.registroPaginas;
			if(this.totalRegistros%this.registroPaginas>0) n++;
		}		
		
		this.numeroPaginas=n;		
		this.inicio=(pagina-1)*registroPaginas;
		this.fin=(pagina)*registroPaginas;
		
		// REGLAS
		// 1 - EL TANTO EL INICIO COMO EL FIN DEBEN SER MAYOR QUE LA CANTIDAD DE REGISTROS
       
		if(this.inicio>=this.totalRegistros ) this.fin= this.totalRegistros;
		if(this.fin>=this.totalRegistros ) this.fin= this.totalRegistros;
		
		
		
		
		
		return this;
		
	}

	public Integer getInicio() {
		return inicio;
	}

	public Integer getFin() {
		return fin;
	}

	public Integer getPagina() {
		return pagina;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public Integer getRegistroPaginas() {
		return registroPaginas;
	}

	public Integer getTotalRegistros() {
		return totalRegistros;
	}
	
	


}

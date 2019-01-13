package dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import pe.gtdo.entitymanager.producer.controller.CrudServiceController;
import utilitario.FechaUtil;
import utilitario.Utilitario;
import utilitario.constante.FiltroSql;
import utilitario.request.RequestData;
import utilitario.request.RequestOrderBy;



public class TransactionDao {

	@EJB
	CrudServiceController crudService;
	
	@Inject
	Utilitario utilitario;
	
	@Inject
	FechaUtil fechaUtil;
	
	/*@Inject
	MpfnLogger LOG;*/
	
	public <T> T create(T t) throws Exception{       
//		setAuditoria(t,TypeAudit.CREATE);
		crudService.create(t);
		//shistorico(t);		
		return t;
	}
	
	public <T> T update(T t) throws Exception{    
	///	setAuditoria(t,TypeAudit.UPDATE);
	    crudService.update(t);
	//	historico(t);
		return t;
	}	
	

	
	public <T> List<T> query(Class clase, RequestData request) throws Exception {		
		String orderBy=orderbySqlRequest(request.getOrderBy(), "u");				
		HashMap<String, Object> parametros = procesarParemetros(clase,request.getWhere(),"u");
		 List resultado=null;
		if(request.getPage()!=null && request.getLimit()!=null){
			
			resultado=crudService.getPaginationQuery("select u from "+clase.getSimpleName()+" u "+parametros.get("addSql")+"   "+orderBy,(HashMap<String, Object>) parametros.get("parametro"), request.getPage(), request.getLimit());
		} 
		else	resultado=crudService.findWithQuery("select u from "+clase.getSimpleName()+" u "+parametros.get("addSql")+"   "+orderBy,(HashMap<String, Object>) parametros.get("parametro"));		
		
		return resultado;	
	}
	

	private HashMap<String,Object> procesarParemetros(Class clase,HashMap<String,Object> parametro,String identificador) throws Exception{
		
		HashMap<String,Object> resultado= new HashMap<String,Object>();
		HashMap<String,Object>  parametroSql=new HashMap<String,Object>();
		resultado.put("addSql","");
		resultado.put("parametro",parametroSql);
		List<String> parametroWhere=new ArrayList<String>();
			for (String key : parametro.keySet()) {
            Integer index=0;  
			index=key.lastIndexOf("_");
			String tipo="";
			if(index>0) tipo=key.substring(index+1);
			switch(FiltroSql.fromType(tipo)){
			
				case IN: parametroSql.put(key.replace(".",""),replaceLista(clase, key, parametro) );
				         parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" in(:"+key.replace(".","")+") ");
				break;	
					
				case NOTIN: parametroSql.put(key.replace(".",""),replaceLista(clase, key, parametro) );
		                    parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" not in(:"+key.replace(".","")+") ");
				break;
				
				case LIKE:  parametroWhere.add(" UPPER("+identificador+"."+key.substring(0, index)+") like '%"+parametro.get(key).toString().toUpperCase()+"%' ");
				break;
				
				case RLIKE:  parametroWhere.add(" UPPER("+identificador+"."+key.substring(0, index)+") like '%"+parametro.get(key).toString().toUpperCase()+"' ");
				break;
				
				case LLIKE:  parametroWhere.add(" UPPER("+identificador+"."+key.substring(0, index)+") like '"+parametro.get(key).toString().toUpperCase()+"%' ");
				break;
				
				case BETWEEN: List<Object> arr =replaceLista(clase, key, parametro); //(List<Object>) parametro.get(key);
							  parametroSql.put("between_1", arr.get(0));
							  parametroSql.put("between_2", arr.get(1));
							  parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" between :between_1 and :between_2 ");
				break;
				
				case BETWEENDATE:  List<Object> arrDate =  (List<Object>) parametro.get(key);
							  parametroSql.put("between_1",  fechaUtil.parseStringToLocalDate(arrDate.get(0).toString(),"yyyy-MM-dd"));
							  parametroSql.put("between_2",  fechaUtil.parseStringToLocalDate(arrDate.get(1).toString(),"yyyy-MM-dd"));
							  parametroWhere.add(" date("+identificador+"."+key.substring(0, index)+") between :between_1 and :between_2 ");
	            break;
				
				case MAI: parametroSql.put(key.replace(".",""), replace(clase, key, parametro) );
                          parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" >=:"+key.replace(".","")+" ");
				break;
				
				case MEI: parametroSql.put(key.replace(".",""), replace(clase, key, parametro));
                          parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" <=:"+key.replace(".","")+" ");
				break;
				
				case MA: parametroSql.put(key.replace(".",""), replace(clase, key, parametro));
                         parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" >:"+key.replace(".","")+" ");
				break;
				
				case ME: parametroSql.put(key.replace(".",""), replace(clase, key, parametro));
                         parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" <:"+key.replace(".","")+" ");
				break;
				
				case DIFERENTE: parametroSql.put(key.replace(".",""), replace(clase, key, parametro));
                                parametroWhere.add(" "+identificador+"."+key.substring(0, index)+" <>:"+key.replace(".","")+" ");
				break;
				
				case DATE: parametroSql.put(key.replace(".",""), fechaUtil.parseStringToLocalDate(parametro.get(key).toString(),"yyyy-MM-dd"));
				           parametroWhere.add(" date("+identificador+"."+key.substring(0, index)+") =:"+key.replace(".","")+"");
				break;
				
				default: parametroSql.put(key.replace(".",""),replace(clase, key, parametro));
                          parametroWhere.add(" "+identificador+"."+key+"=:"+key.replace(".","")+" ");					
			
			}
			
		}		
		String where= (parametroWhere.size()>0)? " where "+String.join(" and ", parametroWhere) :""; 		
		resultado.put("addSql",where);
		resultado.put("parametro",parametroSql);	
		return resultado;
		
	}
	
	public Object replace(Class clase,String key,HashMap<String,Object> parametro) throws Exception{
	     	Integer index = key.lastIndexOf("_")>-1 ? key.lastIndexOf("_"):key.length()  ;
		    Class  claseCampo= getClaseAtributo(clase,key.substring(0, index));	
		    
		    return  castObject(claseCampo,parametro.get(key));
	}
		
	public  List<Object> replaceLista(Class clase,String key,HashMap<String,Object> parametro) throws Exception{
		Integer index = key.lastIndexOf("_")>-1 ? key.lastIndexOf("_"):key.length()  ;
		   Class  claseCampo= getClaseAtributo(clase,key.substring(0, index));		  
		   List<Object> lista = (List<Object>) parametro.get(key);
		   List<Object> listaResultado = new ArrayList<Object>();
		   for(Object item:lista) listaResultado.add(castObject(claseCampo,item));
		   return listaResultado;		   
	}
	
	
    private Class getClaseAtributo(Class clase,String campo)  throws Exception{
   	 String[] lista=campo.split("\\.");
   	 for(String campoAtributo : lista) clase=clase.getDeclaredField(campoAtributo).getType(); 
	 return clase;   
   }
    
    private Object castObject(Class clase,Object object){ 
    	String className=clase.getSimpleName();
    	if(className.equals("Long")) return object=Long.valueOf(object.toString());
    	if(className.equals("Integer")) return  object=Integer.valueOf(object.toString()) ;  
    	if(className.equals("LocalDateTime")) return  object=fechaUtil.parseStringToLocalDateTime(object.toString(),"yyyy-MM-dd HH:mm") ;
    	if(className.equals("LocalDate")) return  object= fechaUtil.parseStringToLocalDate(object.toString(),"yyyy-MM-dd") ;
    	return object;
    	
    }
	
	public String orderbySqlRequest(List<RequestOrderBy> orders, String identificador) {
		if(orders.isEmpty()) return "";
		List<String> resultado = new ArrayList<>();
		String sentido;
		for(RequestOrderBy order : orders) {
			sentido = order.getIsAsc() ? " ASC ": " DESC ";
			resultado.add( identificador + "." + order.getField() + sentido );
		}
		return " order by " + String.join(",", resultado);
	
	}
	
}

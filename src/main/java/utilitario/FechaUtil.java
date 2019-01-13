package utilitario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response.Status;

import exception.AbdcpException;



@ApplicationScoped
public  class FechaUtil {
	
	
	private DateTimeFormatter formatter;
	private String formatDateTime="yyyy-MM-dd HH:mm";
	private String formatDate="yyyy-MM-dd";
	
	
	
	
	public FechaUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate parseStringToDate(String date) throws Exception{		
		try{
			this.formatter=DateTimeFormatter.ofPattern(this.formatDate);
			return LocalDate.parse(date, this.formatter);
		}catch(Exception e){
			throw new AbdcpException(Status.BAD_REQUEST, "  La fecha debe tener el siguinete formato yyyy-MM-dd ");
		}
	}

	public LocalDateTime parseStringToDateTime(String date) throws Exception{		
		try{
			this.formatter=DateTimeFormatter.ofPattern(this.formatDateTime);
			return LocalDateTime.parse(date, this.formatter);
		}catch(Exception e){
			throw new AbdcpException(Status.BAD_REQUEST, "  La fecha debe tener el siguiente formato yyyy-MM-dd HH:mm ");
		}
	}
	
	public String parseDateToString(LocalDate date) throws Exception{		
		try{
			this.formatter=DateTimeFormatter.ofPattern(this.formatDate);
			return date.format(formatter);
		}catch(Exception e){
			throw new AbdcpException(Status.BAD_REQUEST, "  La fecha debe tener el siguiente formato yyyy-MM-dd");
		}
	}


	public String parseDateTimeToString(LocalDateTime date) throws Exception{
		try{
			this.formatter=DateTimeFormatter.ofPattern(this.formatDateTime);
			return date.format(formatter);
		}catch(Exception e){
			throw new AbdcpException(Status.BAD_REQUEST, "  La fecha debe tener el siguiente formato yyyy-MM-dd HH:mm ");
		}
	}
	
	
	public  String parseDate(String fecha,String format) {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		    LocalDateTime formatDateTime = LocalDateTime.parse(fecha, formatter);		    
		    String s = formatDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		    return s;
	}
	
	public static LocalDate parseStringToLocalDate(String fecha,String format) {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		    LocalDate fechaDate = LocalDate.parse(fecha, formatter);
		    return fechaDate;
	}
	public static LocalDateTime parseStringToLocalDateTime(String fecha,String format) {
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);		
		 	LocalDateTime fechaDate = LocalDateTime.parse(fecha, formatter);		 
		 	return fechaDate;
	}
	
	
	
	public  String dateToYYMMdd(String dateYYYYMMdd) {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    	LocalDateTime formatDateTime = LocalDateTime.parse(dateYYYYMMdd, formatter);	    
	    	String s = formatDateTime.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"));
	    	return s;
	}

	public  LocalDateTime dateToddMMyyyy(String dateddMMyyyy) {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    	LocalDateTime formatDateTime = LocalDateTime.parse(dateddMMyyyy, formatter);
	    	return formatDateTime;
	}
	
	public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
	    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	
	
    public  String formatearFecha(String formatoFecha, Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha, new Locale("es","ES"));
        return formato.format(fecha);
    }
	
}

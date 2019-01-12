package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mensage_abdcp database table.
 * 
 */
@Entity
@Table(name="mensage_abdcp")
@NamedQuery(name="MensageAbdcp.findAll", query="SELECT m FROM MensageAbdcp m")
public class MensageAbdcp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String destino;

	private String emisor;

	@Column(name="es_activo")
	private Boolean esActivo;

	@Column(name="fecha_creaacion")
	private Timestamp fechaCreaacion;

	@Column(name="fecha_envio")
	private Timestamp fechaEnvio;

	@Column(name="fecha_respuesta")
	private Timestamp fechaRespuesta;

	@Column(name="id_mensaje")
	private String idMensaje;

	private Object request;

	private Object response;

	private Long version;

	public MensageAbdcp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getEmisor() {
		return this.emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public Boolean getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(Boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Timestamp getFechaCreaacion() {
		return this.fechaCreaacion;
	}

	public void setFechaCreaacion(Timestamp fechaCreaacion) {
		this.fechaCreaacion = fechaCreaacion;
	}

	public Timestamp getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Timestamp getFechaRespuesta() {
		return this.fechaRespuesta;
	}

	public void setFechaRespuesta(Timestamp fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public String getIdMensaje() {
		return this.idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public Object getRequest() {
		return this.request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	public Object getResponse() {
		return this.response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
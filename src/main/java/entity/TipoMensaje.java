package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_mensaje database table.
 * 
 */
@Entity
@Table(name="tipo_mensaje")
@NamedQuery(name="TipoMensaje.findAll", query="SELECT t FROM TipoMensaje t")
public class TipoMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_mensaje")
	private Long idTipoMensaje;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public TipoMensaje() {
	}

	public Long getIdTipoMensaje() {
		return this.idTipoMensaje;
	}

	public void setIdTipoMensaje(Long idTipoMensaje) {
		this.idTipoMensaje = idTipoMensaje;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(Boolean esActivo) {
		this.esActivo = esActivo;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_documento_identidad database table.
 * 
 */
@Entity
@Table(name="tipo_documento_identidad")
@NamedQuery(name="TipoDocumentoIdentidad.findAll", query="SELECT t FROM TipoDocumentoIdentidad t")
public class TipoDocumentoIdentidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_documento_identidad")
	private Long idTipoDocumentoIdentidad;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public TipoDocumentoIdentidad() {
	}

	public Long getIdTipoDocumentoIdentidad() {
		return this.idTipoDocumentoIdentidad;
	}

	public void setIdTipoDocumentoIdentidad(Long idTipoDocumentoIdentidad) {
		this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
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
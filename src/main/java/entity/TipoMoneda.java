package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_moneda database table.
 * 
 */
@Entity
@Table(name="tipo_moneda")
@NamedQuery(name="TipoMoneda.findAll", query="SELECT t FROM TipoMoneda t")
public class TipoMoneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_monedad")
	private Long idTipoMonedad;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public TipoMoneda() {
	}

	public Long getIdTipoMonedad() {
		return this.idTipoMonedad;
	}

	public void setIdTipoMonedad(Long idTipoMonedad) {
		this.idTipoMonedad = idTipoMonedad;
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
package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modalidad database table.
 * 
 */
@Entity
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_modalidad")
	private Long idModalidad;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public Modalidad() {
	}

	public Long getIdModalidad() {
		return this.idModalidad;
	}

	public void setIdModalidad(Long idModalidad) {
		this.idModalidad = idModalidad;
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
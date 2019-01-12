package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_numeracion database table.
 * 
 */
@Entity
@Table(name="estado_numeracion")
@NamedQuery(name="EstadoNumeracion.findAll", query="SELECT e FROM EstadoNumeracion e")
public class EstadoNumeracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_numeracion")
	private Long idEstadoNumeracion;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public EstadoNumeracion() {
	}

	public Long getIdEstadoNumeracion() {
		return this.idEstadoNumeracion;
	}

	public void setIdEstadoNumeracion(Long idEstadoNumeracion) {
		this.idEstadoNumeracion = idEstadoNumeracion;
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
package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_proceso database table.
 * 
 */
@Entity
@Table(name="estado_proceso")
@NamedQuery(name="EstadoProceso.findAll", query="SELECT e FROM EstadoProceso e")
public class EstadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_proceso")
	private Long idEstadoProceso;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public EstadoProceso() {
	}

	public Long getIdEstadoProceso() {
		return this.idEstadoProceso;
	}

	public void setIdEstadoProceso(Long idEstadoProceso) {
		this.idEstadoProceso = idEstadoProceso;
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
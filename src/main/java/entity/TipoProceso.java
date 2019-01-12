package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_proceso database table.
 * 
 */
@Entity
@Table(name="tipo_proceso")
@NamedQuery(name="TipoProceso.findAll", query="SELECT t FROM TipoProceso t")
public class TipoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_proceso")
	private Long idTipoProceso;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public TipoProceso() {
	}

	public Long getIdTipoProceso() {
		return this.idTipoProceso;
	}

	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
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
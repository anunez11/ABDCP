package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_servicio database table.
 * 
 */
@Entity
@Table(name="tipo_servicio")
@NamedQuery(name="TipoServicio.findAll", query="SELECT t FROM TipoServicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_servicio")
	private Long idTipoServicio;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public TipoServicio() {
	}

	public Long getIdTipoServicio() {
		return this.idTipoServicio;
	}

	public void setIdTipoServicio(Long idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
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
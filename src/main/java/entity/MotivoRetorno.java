package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motivo_retorno database table.
 * 
 */
@Entity
@Table(name="motivo_retorno")
@NamedQuery(name="MotivoRetorno.findAll", query="SELECT m FROM MotivoRetorno m")
public class MotivoRetorno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_motivo_retorno")
	private Long idMotivoRetorno;

	private String codigo;

	private String descripcion;

	@Column(name="es_activo")
	private Boolean esActivo;

	public MotivoRetorno() {
	}

	public Long getIdMotivoRetorno() {
		return this.idMotivoRetorno;
	}

	public void setIdMotivoRetorno(Long idMotivoRetorno) {
		this.idMotivoRetorno = idMotivoRetorno;
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
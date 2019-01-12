package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the generador_codigo database table.
 * 
 */
@Entity
@Table(name="generador_codigo")
@NamedQuery(name="GeneradorCodigo.findAll", query="SELECT g FROM GeneradorCodigo g")
public class GeneradorCodigo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_generador")
	private Long idGenerador;

	private String concesionario;

	private Long contador;

	@Column(name="es_activo")
	private Boolean esActivo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="tipo_proceso")
	private String tipoProceso;

	public GeneradorCodigo() {
	}

	public Long getIdGenerador() {
		return this.idGenerador;
	}

	public void setIdGenerador(Long idGenerador) {
		this.idGenerador = idGenerador;
	}

	public String getConcesionario() {
		return this.concesionario;
	}

	public void setConcesionario(String concesionario) {
		this.concesionario = concesionario;
	}

	public Long getContador() {
		return this.contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}

	public Boolean getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(Boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoProceso() {
		return this.tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

}
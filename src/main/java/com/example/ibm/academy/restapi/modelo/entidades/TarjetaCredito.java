package com.example.ibm.academy.restapi.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.ibm.academy.restapi.enumeradores.TipoTarjetaCredito;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjeta_credito", schema = "banamex")
@Inheritance(strategy =InheritanceType.JOINED)
public class TarjetaCredito implements Serializable
{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_tarjeta_credito")
	@Enumerated(EnumType.STRING)
	private TipoTarjetaCredito tipoTarjetaCredito;

	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE_ID"))
	private Clientes clientes;
		
	public TarjetaCredito(Long id, TipoTarjetaCredito tipoTarjetaCredito, String usuarioCreacion) 
	{
		
		this.id = id;
		this.tipoTarjetaCredito = tipoTarjetaCredito;
		this.usuarioCreacion = usuarioCreacion;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TarjetaCredito [id=");
		builder.append(id);
		builder.append(", tipoTarjetaCredito=");
		builder.append(tipoTarjetaCredito);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoTarjetaCredito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		return Objects.equals(id, other.id) && tipoTarjetaCredito == other.tipoTarjetaCredito;
	}

	@PrePersist
	private void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion = new Date();
	}
	

	private static final long serialVersionUID = 1L;

}

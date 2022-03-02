package com.example.ibm.academy.restapi.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.example.ibm.academy.restapi.enumeradores.RangoEdad;
import com.example.ibm.academy.restapi.enumeradores.RangoSalario;
import com.example.ibm.academy.restapi.enumeradores.TipoPreferencias;

public class Clientes implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;
	
	
	
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	
	@Column(name = "rango_edad")
	@Enumerated(EnumType.STRING)
	private RangoEdad rangoEdad;
	
	@Column(name = "rango_salario")
	@Enumerated(EnumType.STRING)
	private RangoSalario rangoSalario;
	
	@Column(name = "tipo_preferencias")
	@Enumerated(EnumType.STRING)
	private TipoPreferencias tipoPreferencias;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<TarjetaCredito> tarjetasCredito;


	
	
	public Clientes(Long id, String nombre, String apellido, String usuarioCreacion, RangoEdad rangoEdad, TipoPreferencias tipoPreferencias, RangoSalario rangoSalario)
	{
		
	
		this.id =id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioCreacion = usuarioCreacion;
		this.rangoEdad = rangoEdad;
		this.rangoSalario = rangoSalario;
		this.tipoPreferencias = tipoPreferencias;
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append(", rangoEdad=");
		builder.append(rangoEdad);
		builder.append(", rangoSalario=");
		builder.append(rangoSalario);
		builder.append(", tipoPreferencias=");
		builder.append(tipoPreferencias);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(id, other.id);
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

package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class Cliente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	private String nombre;
   private String apellido;
   @Column(unique=true)
   private int dni;
   @OneToOne(cascade = CascadeType.ALL) //Sirve para propagar los cambios al objeto relacionado
   @JoinColumn(name = "fk_domicilio")
   private Domicilio domicilio;
   
   @OneToMany(mappedBy ="cliente") //el mappedBy sirve para hacer bidireccional la relacion y tener todas las fac relacionadas con un cliente
   private List<Factura> facturas = new ArrayList<Factura>();	
   
   public Cliente(String nombre,String apellido, int dni ) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	
}

public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.domicilio = domicilio;
}

public Long getId() {
	return id;
}



public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getDni() {
	return dni;
}

public void setDni(int dni) {
	this.dni = dni;
}

public Domicilio getDomicilio() {
	return domicilio;
}

public void setDomicilio(Domicilio domicilio) {
	this.domicilio = domicilio;
}



}

package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Domicilio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nombreCalle;
private int numero;

public Domicilio(String nombreCalle, int numero) {
	this.nombreCalle = nombreCalle;
	this.numero = numero;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombreCalle() {
	return nombreCalle;
}

public void setNombreCalle(String nombreCalle) {
	this.nombreCalle = nombreCalle;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}



}

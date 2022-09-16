package Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int cantidad;
   private String denominacion;
   private int precio;
   
   @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinTable(
		   name= "articulo_categoria",
           joinColumns = @JoinColumn(name="articulo_id"),
           inverseJoinColumns = @JoinColumn(name ="categoria_id"))
   
   private List<Categoria> categorias = new ArrayList<Categoria>();
   
public Articulo(int cantidad, String denominacion, int precio) {
	super();
	this.cantidad = cantidad;
	this.denominacion = denominacion;
	this.precio = precio;
}
public Long getId() {
	return id;
}

public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public String getDenominacion() {
	return denominacion;
}
public void setDenominacion(String denominacion) {
	this.denominacion = denominacion;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public List<Categoria> getCategorias() {
	return categorias;
}
public void setCategorias(Categoria categoria) {
	this.categorias.add(categoria);
}
   
   
   
}

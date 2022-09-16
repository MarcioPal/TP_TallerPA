package Entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String fecha;
   private int numero;
   private int total;
   
   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "fk_cliente")
   private Cliente cliente;
   
   /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
   private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();*/
   
public Factura(String fecha, int numero, int total) {
	super();
	this.fecha = fecha;
	this.numero = numero;
	this.total = total;
}
public Long getId() {
	return id;
}

public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
   
   
  
}

package Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String denominacion;
   
   @ManyToMany(mappedBy= "categorias")
   private List<Articulo> articulos = new ArrayList<Articulo>();

   public Categoria(String denominacion) {
	this.denominacion = denominacion;
}

public Long getId() {
	return id;
}


public String getDenominacion() {
	return denominacion;
}

public void setDenominacion(String denominacion) {
	this.denominacion = denominacion;
}
   

   
   
   
   
}

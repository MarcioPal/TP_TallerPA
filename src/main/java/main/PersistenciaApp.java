package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Articulo;
import Entidades.Categoria;
import Entidades.Cliente;
import Entidades.Domicilio;
import Entidades.Factura;

public class PersistenciaApp {

	public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
      EntityManager em = emf.createEntityManager();
      
      try {
    	  em.getTransaction().begin();
    	  
    	  Factura factura = new Factura("03/05/2019",456321,999);
    	  Cliente cliente = new Cliente("Marcio","Palazzo",43417331);
    	  Domicilio domicilio = new Domicilio("Belgrano",587);
    	 cliente.setDomicilio(domicilio);
    	 
    	  factura.setCliente(cliente);
    	  Categoria perecederos = new Categoria("Perecederos");
    	  Categoria lacteos = new Categoria("lacteos");
    	  Categoria limpieza = new Categoria("Limpieza");
    	  
    	  Articulo art1 = new Articulo(200,"Yogurt",20);
    	  art1.setCategorias(perecederos);
    	  em.persist(cliente); //Para indicar la entidad a persistir  
          em.persist(art1);
          em.persist(factura);
    	  em.flush();
    	  em.getTransaction().commit();
    	  
      }catch(Exception e) {
    	  em.getTransaction().rollback();
    	  
      }

      em.close();
      emf.close();
      
	}

}

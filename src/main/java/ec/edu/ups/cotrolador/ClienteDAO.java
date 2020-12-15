package ec.edu.ups.cotrolador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Cliente;

@Stateless
public class ClienteDAO {

	@PersistenceContext(name="NautaJessicaServidorPersistenceUnit")
	private EntityManager em;
    
    public void insertar(Cliente cliente) {
		em.persist(cliente);
	}
	

	public Cliente buscarCedula(String cedula) throws Exception {
		//return em.find(Cliente.class, cedula);
		try {
        	String jpql = "SELECT c FROM Cliente c WHERE c.cedula = :cedula";
            Query q = em.createQuery(jpql, Cliente.class);
            q.setParameter("cedula", cedula);

            System.out.println("cedula: " + jpql);
            System.out.println("ced: " + q);
            //return em.find(Cliente.class, q);
            return (Cliente) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error al buscar por cedula");
        }
	}

	
	
	public List<Cliente> listaClientes() {
		String jpql = "SELECT c FROM Cliente c ";
		Query q = em.createQuery(jpql, Cliente.class);		
		return q.getResultList();
	}
	
}

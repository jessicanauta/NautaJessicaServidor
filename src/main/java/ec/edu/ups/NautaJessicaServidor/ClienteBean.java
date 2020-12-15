package ec.edu.ups.NautaJessicaServidor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.negocio.ClienteON;
import ec.edu.ups.negocio.ClienteONLocal;

@ManagedBean
@SessionScoped
public class ClienteBean {

	@Inject
	private ClienteONLocal on;
	
	private Cliente newCliente;
	
	private List<Cliente> listarClientes;
	
	private String cedula;
	
	private Date fecha;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	
	@PostConstruct
	public void init() {
		newCliente = new Cliente();
		loadDataPersonas();
	}

	

	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public Cliente getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Cliente newCliente) {
		this.newCliente = newCliente;
	}

	public List<Cliente> getListarClientes() {
		return listarClientes;
	}

	public void setListarClientes(List<Cliente> listarClientes) {
		this.listarClientes = listarClientes;
	}
	
	public String guardarDatos() {

		System.out.println(this.toString());

		try {
			on.guardarContacto(newCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void loadDataPersonas() {
		listarClientes = on.listaCliente();

	}
	
	public void buscar() {
		newCliente = on.obtenerCedula(cedula);		
	}
	
}

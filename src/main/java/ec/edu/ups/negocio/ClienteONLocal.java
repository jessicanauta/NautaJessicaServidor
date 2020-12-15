package ec.edu.ups.negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.modelo.Cliente;

@Local
public interface ClienteONLocal {
	
	public void guardarContacto(Cliente cliente) throws Exception;
	public Cliente obtenerCedula(String cedula);
	public List<Cliente> listaCliente();
	public void fecha(Date date);
	public boolean validarCedula(String ced);
}

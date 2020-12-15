package ec.edu.ups.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.cotrolador.ClienteDAO;
import ec.edu.ups.modelo.Cliente;

@Stateless
public class ClienteON implements ClienteONLocal, ClienteONRemoto{
	
	@Inject
	private ClienteDAO clientedao;

	public ClienteON() {
	}

	public void guardarContacto(Cliente cliente) throws Exception {
		if (validarCedula(cliente.getCedula())) {
			try {
				clientedao.insertar(cliente);
			} catch (Exception e) {
				throw new Exception("Error al ingresar Contacto");
			}
		} else {
			throw new Exception("Cedula Incorrecta");
		}
	}
	
	public Cliente obtenerCedula(String cedula) {
		try {
			return clientedao.buscarCedula(cedula);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Cliente> listaCliente() {
		return clientedao.listaClientes();
	}
	
	public void fecha(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(dateFormat.format(date));

	}
	
	public boolean validarCedula(String ced) {
		boolean verdadera = false;
		int num = 0;
		int ope = 0;
		int suma = 0;
		for (int cont = 0; cont < ced.length(); cont++) {
			num = Integer.valueOf(ced.substring(cont, cont + 1));
			if (cont == ced.length() - 1) {
				break;
			}
			if (cont % 2 != 0 && cont > 0) {
				suma = suma + num;
			} else {
				ope = num * 2;
				if (ope > 9) {
					ope = ope - 9;
				}
				suma = suma + ope;
			}
		}
		if (suma != 0) {
			suma = suma % 10;
			if (suma == 0) {
				if (suma == num) {
					verdadera = true;
				}
			} else {
				ope = 10 - suma;
				if (ope == num) {
					verdadera = true;
				}
			}
		} else {
			verdadera = false;
		}
		return verdadera;
	}
}

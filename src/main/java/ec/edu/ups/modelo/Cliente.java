package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String fecha;
	//private Date fecha_nacimiento;
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
//	public Date getFecha_nacimiento() {
//		return fecha_nacimiento;
//	}
//
//	public void setFecha_nacimiento(Date fecha_nacimiento) {
//		this.fecha_nacimiento = fecha_nacimiento;
//	}
	
	

}

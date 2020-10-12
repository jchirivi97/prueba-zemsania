package prueba.zemsania.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class cliente {

	@Id
	private int id_cliente;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private String password;
	
	@OneToMany(targetEntity=venta.class)
	private List ventaList;
	
	public cliente(){
		
	}
	
	public cliente(int idCliente, String nombre, String apellido, String dni,
			String telefono, String email, String password) {
		this.id_cliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}
	
	public int getIdCliente() {
		return id_cliente;
	}
	public void setIdCliente(int idCliente) {
		this.id_cliente = idCliente;
	}
	public List getVentaList() {
		return ventaList;
	}

	public void setVentaList(List ventaList) {
		this.ventaList = ventaList;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

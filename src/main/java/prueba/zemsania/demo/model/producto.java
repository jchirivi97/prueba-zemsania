package prueba.zemsania.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class producto {
	
	@Id
	private int id_producto;
	private String nombre;
	private long precio;
	
		
	public producto(){
		
	}
	
	public producto(int idProducto, String nombre, Long precio) {
		this.id_producto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getIdProducto() {
		return id_producto;
	}
	public void setIdProducto(int idProducto) {
		this.id_producto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	
	
	
}

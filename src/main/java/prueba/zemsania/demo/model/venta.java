package prueba.zemsania.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class venta {
	
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id_venta;
	private Date fecha;
	private int id_cliente;
	
	public venta(){
		
	}
	
	public venta(int id_venta, Date fecha,int id_cliente) {
		this.id_venta = id_venta;
		this.fecha = fecha;
		this.id_cliente = id_cliente;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}

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
	
	public venta(){
		
	}
	
	public venta(int id_venta, Date fecha) {
		this.id_venta = id_venta;
		this.fecha = fecha;
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

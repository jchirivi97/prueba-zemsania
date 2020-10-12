package prueba.zemsania.demo.service;

import java.util.List;

import prueba.zemsania.demo.model.detalleVenta;

public interface detalleVentaService {
	
	void saveDetalle(detalleVenta detalle);
	
	List<detalleVenta> getDetalle(int idventa);
		
}

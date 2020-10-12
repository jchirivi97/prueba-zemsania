package prueba.zemsania.demo.service;

import prueba.zemsania.demo.model.detalleVenta;

public interface detalleVentaService {
	
	void saveDetalle(detalleVenta detalle);
	
	detalleVenta getDetalle(int idventa);
		
}

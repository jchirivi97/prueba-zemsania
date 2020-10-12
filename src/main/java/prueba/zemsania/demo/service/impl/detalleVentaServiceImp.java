package prueba.zemsania.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.zemsania.demo.model.detalleVenta;
import prueba.zemsania.demo.model.producto;
import prueba.zemsania.demo.repository.detalleVentaRepository;
import prueba.zemsania.demo.service.detalleVentaService;

@Service 
public class detalleVentaServiceImp implements detalleVentaService {
	
	@Autowired
	detalleVentaRepository detalleVentaRep;

	@Override
	public void saveDetalle(detalleVenta detalle) {
		detalleVentaRep.save(detalle);
	}

	@Override
	public detalleVenta getDetalle(int idventa) {
		return detalleVentaRep.getDetalle(idventa);
	}

}

package prueba.zemsania.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.zemsania.demo.model.producto;
import prueba.zemsania.demo.model.venta;
import prueba.zemsania.demo.repository.ventaRepository;
import prueba.zemsania.demo.service.ventaService;


@Service
public class ventaServiceImp implements ventaService {

	@Autowired
	ventaRepository ventaRep;

	@Override
	public List<venta> getAllClient(int idclient) {
		return ventaRep.getAllVentasClient(idclient);
	}

	@Override
	public venta saveVenta(venta venta) {
		return ventaRep.save(venta);
	}
	
	
	
}

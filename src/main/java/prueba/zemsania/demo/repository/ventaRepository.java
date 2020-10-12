package prueba.zemsania.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prueba.zemsania.demo.model.venta;

public interface ventaRepository extends JpaRepository<venta,Integer>{
	
	@Query(value="select v.id_venta,v.id_cliente,v.fecha from venta v where v.id_cliente = ?1",nativeQuery=true)
	List<venta> getAllVentasClient(int idcliente);
	
}

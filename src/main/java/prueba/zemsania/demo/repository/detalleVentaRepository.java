package prueba.zemsania.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prueba.zemsania.demo.model.detalleVenta;

public interface detalleVentaRepository extends  JpaRepository<detalleVenta,Integer> {

	@Query(value="select d.id_detalle, d.id_producto, d.id_venta from detalle_venta d where d.id_venta = ?1",nativeQuery=true)
	List<detalleVenta> getDetalle(int idVenta);
}

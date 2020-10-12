package prueba.zemsania.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prueba.zemsania.demo.model.producto;

public interface productoRepository extends JpaRepository<producto,Integer>{
	
	@Query(value="update producto p set p.nombre= ?2 , p.precio = ?3 where p.idProducto = ?1",nativeQuery=true)
	void updateProduct(int idProducto,String nombre,Long precio);
}

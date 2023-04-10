package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoDao extends JpaRepository<Producto, Long> {
    @Query(value = "SELECT * from producto where enabled =1",nativeQuery = true)
    List<Producto> listarProducto();

}

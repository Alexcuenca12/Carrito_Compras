package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Long> {

}

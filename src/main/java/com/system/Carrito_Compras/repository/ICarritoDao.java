package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarritoDao extends JpaRepository<Carrito,Long> {

    @Query(value = "SELECT * from carrito where enabled =1",nativeQuery = true)
    List<Carrito> listarCarrito();

}

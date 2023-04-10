package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Producto;
import com.system.Carrito_Compras.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRolDao extends JpaRepository<Rol, Long> {
    @Query(value = "SELECT * from roles where enabled =1",nativeQuery = true)
    List<Rol> listarRol();
}

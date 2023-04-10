package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoriaDao extends JpaRepository<Categoria,Long> {
    @Query(value = "SELECT * from categoria where enabled =1",nativeQuery = true)
    List<Categoria> listarCategoria();
}

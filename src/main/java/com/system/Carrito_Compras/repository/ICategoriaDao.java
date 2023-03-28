package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDao extends JpaRepository<Categoria,Long> {
}

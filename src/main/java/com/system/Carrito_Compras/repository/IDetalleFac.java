package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Detalle_Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleFac  extends JpaRepository<Detalle_Carrito,Long> {

}

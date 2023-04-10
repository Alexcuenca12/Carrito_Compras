package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Detalle_Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDetalleFac  extends JpaRepository<Detalle_Carrito,Long> {

    @Query(value = "SELECT * from detalle_carrito where enabled =1",nativeQuery = true)
    List<Detalle_Carrito> listarDetalle();

}

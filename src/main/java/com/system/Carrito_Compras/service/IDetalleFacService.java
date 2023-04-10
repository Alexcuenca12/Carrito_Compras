package com.system.Carrito_Compras.service;



import com.system.Carrito_Compras.entity.Detalle_Carrito;

import java.util.List;

public interface IDetalleFacService extends IGenericService <Detalle_Carrito,Long>{

    public List<Detalle_Carrito> listar() ;


}

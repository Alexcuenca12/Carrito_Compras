package com.system.Carrito_Compras.service;


import com.system.Carrito_Compras.entity.Producto;

import java.util.List;

public interface IProductoService extends IGenericService<Producto, Long>{

    public List<Producto> listar();

}

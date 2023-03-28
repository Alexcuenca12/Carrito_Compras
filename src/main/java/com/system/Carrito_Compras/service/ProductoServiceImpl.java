package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Producto;
import com.system.Carrito_Compras.repository.IProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements IProductoService {

    @Autowired
    IProductoDao productoDao;
    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoDao;
    }
}
package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Carrito;
import com.system.Carrito_Compras.entity.Categoria;
import com.system.Carrito_Compras.repository.ICarritoDao;
import com.system.Carrito_Compras.repository.ICategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl  extends GenericServiceImpl<Carrito, Long> implements ICarritoService{
    @Autowired
    ICarritoDao carritoDao;
    @Override
    public CrudRepository<Carrito, Long> getDao() {
        return carritoDao;
    }

    @Override
    public Carrito search(String id_carrito) {
        return null;
    }

    @Override
    public List<Carrito> listar() {
        return carritoDao.listarCarrito();
    }
}

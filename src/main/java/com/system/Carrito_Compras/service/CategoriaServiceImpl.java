package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Categoria;
import com.system.Carrito_Compras.repository.ICategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<Categoria, Long> implements ICategoriaService {
    @Autowired
    ICategoriaDao categoriaDao;
    @Override
    public CrudRepository<Categoria, Long> getDao() {
        return categoriaDao;
    }
}

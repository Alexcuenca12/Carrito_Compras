package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Categoria;

import java.util.List;

public interface ICategoriaService extends IGenericService<Categoria, Long>{

    public List<Categoria> listar();
}

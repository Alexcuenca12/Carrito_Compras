package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Carrito;
import com.system.Carrito_Compras.entity.Persona;

import java.util.List;


public interface ICarritoService extends IGenericService<Carrito, Long>{

    public Carrito search(String id_carrito);

    public List<Carrito> listar();


}

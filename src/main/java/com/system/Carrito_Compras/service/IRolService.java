package com.system.Carrito_Compras.service;



import com.system.Carrito_Compras.entity.Rol;

import java.util.List;

public interface IRolService extends IGenericService<Rol, Long>{
    public List<Rol> listar();
}

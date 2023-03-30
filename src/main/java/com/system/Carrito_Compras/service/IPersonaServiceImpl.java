package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Persona;
import com.system.Carrito_Compras.repository.IPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements IPersonaService {

    @Autowired
    IPersonaDao productoDao;
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return productoDao;
    }

    @Override
    public Persona search(String cedula) {
        return null;
    }

    @Override
    public List<Persona> listar() {
        return null;
    }
}

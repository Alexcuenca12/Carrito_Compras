package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Detalle_Carrito;
import com.system.Carrito_Compras.entity.Rol;
import com.system.Carrito_Compras.repository.IDetalleFac;
import com.system.Carrito_Compras.repository.IRolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDetalleServiceImpl extends GenericServiceImpl <Detalle_Carrito , Long>  implements IDetalleFacService{


    @Autowired
    IDetalleFac DetalleRepository;

    @Override
    public CrudRepository<Detalle_Carrito, Long> getDao() {
        return DetalleRepository;
    }

    @Override
    public List<Detalle_Carrito> listar() {
        return DetalleRepository.listarDetalle();
    }
}

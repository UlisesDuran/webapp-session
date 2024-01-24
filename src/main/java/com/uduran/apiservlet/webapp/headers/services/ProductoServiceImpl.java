package com.uduran.apiservlet.webapp.headers.services;

import com.uduran.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 150),
                new Producto(2L, "mesa ordenador", "mueble", 200),
                new Producto(3L, "Teclado mecanico", "computacion", 100));
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        ProductoService service = new ProductoServiceImpl();
        return service.listar().stream().filter(p -> {
            if (nombre.isBlank() || nombre==null){
                return false;
            }
            return p.getNombre().contains(nombre);
        }).findFirst();
    }
}

package edu.comillas.icai.gitt.pat.spring.p2.service;

import edu.comillas.icai.gitt.pat.spring.p2.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.p2.entity.LineaCarrito;

import java.util.List;

public interface ServicioInt {
    //DECLARAMOS AQUÍ LOS MÉTODOS

        Carrito creaCarrito(Carrito carrito);

        void deleteCarrito(Carrito carrito);

        Carrito datos(Long idCarrito);

        Carrito anadirLinea(Long idCarrito, LineaCarrito linea);

        void borrarLinea(Long idCarrito, Long idLinea);

        List<LineaCarrito> leeLineas();

    }


package edu.comillas.icai.gitt.pat.spring.p2.service;

import edu.comillas.icai.gitt.pat.spring.p2.Repositorios.RepoCarrito;
import edu.comillas.icai.gitt.pat.spring.p2.Repositorios.RepoLinea;
import edu.comillas.icai.gitt.pat.spring.p2.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.p2.entity.LineaCarrito;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicio implements ServicioInt{
    @Autowired
    private RepoCarrito repoCarrito;

    @Autowired
    private RepoLinea repoLinea;



    //CREAMOS UN NUEVO CARRITO
    public Carrito creaCarrito(Carrito nuevoCarrito) {
        return repoCarrito.save(nuevoCarrito);
   }

    //Leemos carrito
    public Carrito datos(Long idCarrito){
        return repoCarrito.findById(idCarrito).orElse(null);
    }


    //ELIMINAMOS CARRITO
    public void deleteCarrito(Carrito carrito){
        repoCarrito.delete(carrito);
    }



    //LEEMOS LAS LINEAS DE TODOS LOS CARRITOS
    public List<LineaCarrito> leeLineas() {
        return (List<LineaCarrito>) repoLinea.findAll();
    }

    //LEEMOS UNA LINEA DEL CARRITO
    public List<LineaCarrito> leeLineas(Long idCarrito) {
        return repoLinea.findByCarrito_IdCarrito(idCarrito);
    }

    //PARA CREAR Y ELIMINAR UNA NUEVA LINEA HAY QUE HACER OTRO METODO
//PODEMOS CREAR LA LINEA PERO FALLA AL GUARDAR EL CARRITO POR ESO USAMOS TRANSACTIONAL

    @Transactional
    public Carrito anadirLinea(Long idCarrito, LineaCarrito nuevaLinea) {
        Carrito carrito = repoCarrito.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado: " + idCarrito));

        // asociar al carrito (FK)
        nuevaLinea.setCarrito(carrito);

        // calcular costeLinea
        nuevaLinea.setCosteLinea(nuevaLinea.getPrecioUnitario() * nuevaLinea.getNumUnidades());

        // guardar línea
        repoLinea.save(nuevaLinea);

        // recalcular totalPrecio
        int total = repoLinea.findByCarrito_IdCarrito(idCarrito)
                .stream()
                .mapToInt(LineaCarrito::getCosteLinea)
                .sum();

        carrito.setTotalPrecio(total);
        return repoCarrito.save(carrito);
    }

    //BORRAR LÍNEA DE CARRITO (endpoint nuevo)
    @Transactional
    public void borrarLinea(Long idCarrito, Long idLinea) {
        Carrito carrito = repoCarrito.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado: " + idCarrito));

        LineaCarrito linea = repoLinea.findById(idLinea)
                .orElseThrow(() -> new RuntimeException("Linea no encontrada: " + idLinea));

        // seguridad: que la linea sea del carrito
        if (!linea.getCarrito().getIdCarrito().equals(carrito.getIdCarrito())) {
            throw new RuntimeException("La línea no pertenece al carrito " + idCarrito);
        }

        repoLinea.delete(linea);

        // recalcular totalPrecio
        int total = repoLinea.findByCarrito_IdCarrito(idCarrito)
                .stream()
                .mapToInt(LineaCarrito::getCosteLinea)
                .sum();

        carrito.setTotalPrecio(total);
        repoCarrito.save(carrito);
    }




}

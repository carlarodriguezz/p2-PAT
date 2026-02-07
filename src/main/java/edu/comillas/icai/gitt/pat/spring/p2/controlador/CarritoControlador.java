package edu.comillas.icai.gitt.pat.spring.p2.controlador;

import edu.comillas.icai.gitt.pat.spring.p2.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CarritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @GetMapping("/api/carrito")
    public Collection<Carrito> getCarritos() {
        // Carrito demo = new Carrito(1,1,"camiseta", 2, 35);
        return carritos.values();
    }

    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@RequestBody Carrito carrito) {
        carritos.put(carrito.getIdCarrito(), carrito);
        return carrito;
    }

    @PutMapping("/api/carrito/{idCarrito}")
    public Carrito modificaCarrito(@PathVariable int idCarrito,
                                   @RequestBody Carrito carrito) {
        carritos.put(idCarrito, carrito);
        return carrito;
    }


    //@PostMapping("/api/contadores")
    //@ResponseStatus(HttpStatus.CREATED)
    //public ModeloContador crea(@RequestBody ModeloContador contadorNuevo) {
    //    contadores.put(contadorNuevo.nombre(), contadorNuevo);
    //    return contadorNuevo;
    //}

    //@GetMapping("/api/contadores/{nombre}")
    //public ModeloContador contador(@PathVariable String nombre) {
    //    return contadores.get(nombre);
    //}

    //@PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
    //public ModeloContador incrementa(@PathVariable String nombre,
    //                                 @PathVariable Integer incremento) {
        //    ModeloContador contadorActual = contadores.get(nombre);
        //    ModeloContador contadorIncrementado =
                //            new ModeloContador(nombre, contadorActual.valor() + incremento);
    //    contadores.put(nombre, contadorIncrementado);
    //    return contadorIncrementado;
    //}
}

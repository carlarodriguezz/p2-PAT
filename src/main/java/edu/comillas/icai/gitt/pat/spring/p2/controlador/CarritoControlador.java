package edu.comillas.icai.gitt.pat.spring.p2.controlador;

import edu.comillas.icai.gitt.pat.spring.p2.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.p2.entity.LineaCarrito;
import edu.comillas.icai.gitt.pat.spring.p2.service.ServicioInt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CarritoControlador {

    @Autowired
    private ServicioInt servicioInt;

    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@Valid @RequestBody Carrito carrito) {
        try {
            return servicioInt.creaCarrito(carrito);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

    @GetMapping("/api/carrito/{idCarrito}")
    public Carrito getCarrito(@PathVariable Long idCarrito) {
        Carrito c = servicioInt.datos(idCarrito);
        if (c == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        return c;
    }

    @DeleteMapping("/api/carrito/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarrito(@PathVariable Long idCarrito) {
        Carrito carrito = servicioInt.datos(idCarrito);
        if (carrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        servicioInt.deleteCarrito(carrito);
    }

    @PutMapping("/api/carrito/{idCarrito}")
    public Carrito modificaCarrito(@PathVariable Long idCarrito,
                                   @Valid @RequestBody Carrito carrito) {
        // Asegura que actualizas el mismo carrito del path
        carrito.setIdCarrito(idCarrito);
        return servicioInt.creaCarrito(carrito); // save() actualiza si el id existe
    }

    @GetMapping("/api/lineas")
    public List<LineaCarrito> getLineas() {
        return servicioInt.leeLineas();
    }

    @PostMapping("/api/carrito/{idCarrito}/lineas")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito anadirLinea(@PathVariable Long idCarrito,
                               @Valid @RequestBody LineaCarrito linea) {
        return servicioInt.anadirLinea(idCarrito, linea);
    }

    @DeleteMapping("/api/carrito/{idCarrito}/lineas/{idLinea}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarLinea(@PathVariable Long idCarrito,
                            @PathVariable Long idLinea) {
        servicioInt.borrarLinea(idCarrito, idLinea);
    }
}
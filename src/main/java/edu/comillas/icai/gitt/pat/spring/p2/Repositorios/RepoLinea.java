package edu.comillas.icai.gitt.pat.spring.p2.Repositorios;

import edu.comillas.icai.gitt.pat.spring.p2.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.p2.entity.LineaCarrito;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoLinea extends CrudRepository<LineaCarrito, Long> {
    List<LineaCarrito> findByCarrito_IdCarrito(Long carrito);

}

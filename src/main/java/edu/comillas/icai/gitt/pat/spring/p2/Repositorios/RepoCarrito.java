package edu.comillas.icai.gitt.pat.spring.p2.Repositorios;

import edu.comillas.icai.gitt.pat.spring.p2.entity.Carrito;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepoCarrito extends CrudRepository<Carrito, Long> {

    Optional<Carrito> findByEmail(String email);

}

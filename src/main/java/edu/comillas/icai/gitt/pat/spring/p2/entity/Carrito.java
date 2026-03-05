package edu.comillas.icai.gitt.pat.spring.p2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name="Carrito")
public class Carrito {
    //Aqui id carrito es onetomany
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<LineaCarrito> lineas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;

    @Column(unique=true, nullable=false)
    private int IdUsuario;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable=false)
    private int precio;

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Carrito(){}








    }

package edu.comillas.icai.gitt.pat.spring.p2.modelo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Carrito {

    @NotNull
    @Min(1)
    private Integer idCarrito;

    @NotNull
    @Min(1)
    private Integer idArticulo;

    @NotBlank
    private String descripcion;

    @NotNull
    @Min(1)
    private Integer unidades;

    @NotNull
    @Min(0)
    private Double precioFinal;

    public Carrito() {
        // constructor vacío obligatorio para Spring/Jackson
    }

    public Carrito(Integer idCarrito, Integer idArticulo, String descripcion,
                   Integer unidades, Double precioFinal) {
        this.idCarrito = idCarrito;
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precioFinal = precioFinal;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
}

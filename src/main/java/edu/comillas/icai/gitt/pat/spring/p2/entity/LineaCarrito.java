package edu.comillas.icai.gitt.pat.spring.p2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="LineaCarrito")
public class LineaCarrito {

    @ManyToOne(optional=false)
    @JoinColumn(name="idCarrito", nullable=false)
    private Carrito carrito;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinea;

    @Column(unique=true, nullable=false)
    private int idArticulo;

    @Column(nullable=false)
    private int precioUnitario;

    @Column(nullable=false)
    private int numUnidades;

    @Column(nullable=false)
    private int costeLinea;

    public LineaCarrito(){}


    public void recalcularCoste() {
        this.costeLinea = this.precioUnitario * this.numUnidades;
    }


    public Long getIdCarrito() {
        return idLinea;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idLinea = idCarrito;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public int getCosteLinea() {
        return costeLinea;
    }

    public void setCosteLinea(int costeLinea) {
        this.costeLinea = costeLinea;
    }





}

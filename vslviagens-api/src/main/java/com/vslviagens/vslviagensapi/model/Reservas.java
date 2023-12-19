package com.vslviagens.vslviagensapi.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Usuarios cliente;

    @ManyToOne
    @JoinColumn(name = "voo")
    private Voos voo;

    private BigDecimal totalReserva;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Pedidos_Reservas> pedidos;

    public Reservas() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }

    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }

    public BigDecimal getTotalreserva() {
        return totalReserva;
    }

    public void setTotalreserva(BigDecimal totalReserva) {
        this.totalReserva = totalReserva;
    }

    public List<Pedidos_Reservas> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos_Reservas> pedidos) {
        this.pedidos = pedidos;
    }

    public Reservas(Long id, Usuarios cliente, Voos voo, BigDecimal totalReserva, List<Pedidos_Reservas> pedidos) {
        this.id = id;
        this.cliente = cliente;
        this.voo = voo;
        this.totalReserva = totalReserva;
        this.pedidos = pedidos;
    }

}

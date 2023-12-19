package com.vslviagens.vslviagensapi.model;

import java.math.BigDecimal;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedidos_Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva")
    private Reservas reserva;

    @ManyToOne
    @JoinColumn(name = "produto")
    private Detalhes_Voos produto;

    private int quantidade;

    private BigDecimal total;

    public Pedidos_Reservas() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Detalhes_Voos getProduto() {
        return produto;
    }

    public void setProduto(Detalhes_Voos produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Pedidos_Reservas(Long id, Reservas reserva, Detalhes_Voos produto, int quantidade, BigDecimal total) {
        this.id = id;
        this.reserva = reserva;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

}

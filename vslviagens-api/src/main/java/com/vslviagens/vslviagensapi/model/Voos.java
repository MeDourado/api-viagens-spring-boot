package com.vslviagens.vslviagensapi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Voos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @ManyToOne
    @JoinColumn(name = "origem")
    private Paises origem;

    @ManyToOne
    @JoinColumn(name = "destino")
    private Paises destino;

    private LocalDate partida;

    private LocalDate chegada;

    public Voos() {

    }

    public Voos(Long id, String codigo, Paises origem, Paises destino, LocalDate partida, LocalDate chegada) {
        this.id = id;
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.partida = partida;
        this.chegada = chegada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Paises getOrigem() {
        return origem;
    }

    public void setOrigem(Paises origem) {
        this.origem = origem;
    }

    public Paises getDestino() {
        return destino;
    }

    public void setDestino(Paises destino) {
        this.destino = destino;
    }

    public LocalDate getPartida() {
        return partida;
    }

    public void setPartida(LocalDate partida) {
        this.partida = partida;
    }

    public LocalDate getChegada() {
        return chegada;
    }

    public void setChegada(LocalDate chegada) {
        this.chegada = chegada;
    }
}

package com.vslviagens.vslviagensapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Destinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paises pais;

    private String destino;
    private String descricao;
    private String cep;
    private String temporadaRecomendada;
    private String clima;

    public Destinos() {

    }

    public Destinos(Long id, Paises pais, String destino, String descricao, String cep, String temporadaRecomendada,
            String clima) {
        this.id = id;
        this.pais = pais;
        this.destino = destino;
        this.descricao = descricao;
        this.cep = cep;
        this.temporadaRecomendada = temporadaRecomendada;
        this.clima = clima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTemporadaRecomendada() {
        return temporadaRecomendada;
    }

    public void setTemporadaRecomendada(String temporadaRecomendada) {
        this.temporadaRecomendada = temporadaRecomendada;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}

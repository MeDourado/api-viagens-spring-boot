package com.vslviagens.vslviagensapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalhes_Voos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voo")
    private Voos voo;

    private ClasseVooRole classe;

    private double preco;

    private double passageiros;

    public Detalhes_Voos(Long id, Voos voo, ClasseVooRole classe, double preco, double passageiros) {
        this.id = id;
        this.voo = voo;
        this.classe = classe;
        this.preco = preco;
        this.passageiros = passageiros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }

    public ClasseVooRole getClasse() {
        return classe;
    }

    public void setClasse(ClasseVooRole classe) {
        this.classe = classe;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(double passageiros) {
        this.passageiros = passageiros;
    }

    public Detalhes_Voos() {

    }

}

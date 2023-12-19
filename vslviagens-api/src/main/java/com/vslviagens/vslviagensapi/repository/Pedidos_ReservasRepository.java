package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Pedidos_Reservas;

@Repository
public interface Pedidos_ReservasRepository extends JpaRepository<Pedidos_Reservas, Long> {

}

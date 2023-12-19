package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {

}

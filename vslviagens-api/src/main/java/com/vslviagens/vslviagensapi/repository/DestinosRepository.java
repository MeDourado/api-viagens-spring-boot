package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Destinos;

@Repository
public interface DestinosRepository extends JpaRepository<Destinos, Long> {

    Destinos findByDestino(String destino);
}

package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Voos;

@Repository
public interface VoosRepository extends JpaRepository<Voos, Long> {
    Voos findByCodigo(String codigo);
}

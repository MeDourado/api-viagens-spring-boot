package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Long> {

    Paises findByNome(String nome);
}

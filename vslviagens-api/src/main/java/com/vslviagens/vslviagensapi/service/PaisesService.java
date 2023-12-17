package com.vslviagens.vslviagensapi.service;

import java.util.List;

import com.vslviagens.vslviagensapi.model.Paises;

public interface PaisesService {
    List<Paises> listarPaises();

    Paises cadastrarPais(Paises paises);

    Paises buscarPaisPorId(Long id);

    void deletarPais(Long id);

    Paises atualizarPais(Long id, Paises dadosAtualizados);

}

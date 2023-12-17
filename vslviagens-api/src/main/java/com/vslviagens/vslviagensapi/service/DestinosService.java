package com.vslviagens.vslviagensapi.service;

import java.util.List;

import com.vslviagens.vslviagensapi.model.Destinos;

public interface DestinosService {

    List<Destinos> listarDestinos();

    Destinos cadastrarDestinos(Destinos destinos);

    Destinos buscarDestinoPorId(Long id);

    void deletarDestino(Long id);

    Destinos atualizarDestino(Long id, Destinos dadosAtualizados);

}

package com.vslviagens.vslviagensapi.service;

import java.util.List;

import com.vslviagens.vslviagensapi.model.Voos;

public interface VoosService {
    List<Voos> listarVoos();

    Voos cadastrarVoo(Voos voo);

    Voos buscarVooPorId(Long id);

    Voos buscarVooPorCodigo(String codigo);

    void deletarVoo(Long id);

    Voos atualizarVoo(Long id, Voos dadosAtualizados);
}

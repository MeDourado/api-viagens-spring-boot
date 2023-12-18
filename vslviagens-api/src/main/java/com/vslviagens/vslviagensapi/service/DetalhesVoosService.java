package com.vslviagens.vslviagensapi.service;

import java.util.List;

import com.vslviagens.vslviagensapi.dto.DetalhesVoosDTO;
import com.vslviagens.vslviagensapi.model.Detalhes_Voos;

public interface DetalhesVoosService {

    Detalhes_Voos cadastrarDetalhesVoosDTO(DetalhesVoosDTO detalhesVoosDTO);

    Detalhes_Voos atualizarDetalhes_Voos(Long id, DetalhesVoosDTO dadosAtualizados);

    void deletarDetalhes_Voos(Long id);

    List<Detalhes_Voos> listarDetalhesVoosPorVoo(Long vooId);
}

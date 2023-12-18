package com.vslviagens.vslviagensapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vslviagens.vslviagensapi.dto.DetalhesVoosDTO;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Detalhes_Voos;
import com.vslviagens.vslviagensapi.model.Voos;
import com.vslviagens.vslviagensapi.repository.Detalhes_VoosRepository;
import com.vslviagens.vslviagensapi.repository.VoosRepository;
import com.vslviagens.vslviagensapi.service.DetalhesVoosService;

@Service
public class DetalhesVoosServiceImpl implements DetalhesVoosService {

    @Autowired
    private VoosRepository voosRepository;

    @Autowired
    private Detalhes_VoosRepository detalhes_VoosRepository;

    @Override
    public Detalhes_Voos cadastrarDetalhesVoosDTO(DetalhesVoosDTO detalhesVoosDTO) {
        Voos voo = voosRepository.findById(detalhesVoosDTO.vooId())
                .orElse(null);

        if (voo == null) {
            throw new RecursoNaoEncontradoException("Voo não encontrado com o ID");
        }

        Detalhes_Voos detalhesVoos = new Detalhes_Voos();
        detalhesVoos.setVoo(voo);
        detalhesVoos.setClasse(detalhesVoosDTO.classe());
        detalhesVoos.setPreco(detalhesVoosDTO.preco());
        detalhesVoos.setPassageiros(detalhesVoosDTO.passageiros());

        return detalhes_VoosRepository.save(detalhesVoos);

    }

    @Override
    public Detalhes_Voos atualizarDetalhes_Voos(Long id, DetalhesVoosDTO dadosAtualizados) {
        Optional<Detalhes_Voos> detalhes_VoosExiste = detalhes_VoosRepository.findById(id);

        if (detalhes_VoosExiste.isEmpty()) {
            throw new RecursoNaoEncontradoException("Detalhes não encontrado com o ID" + id);
        }

        Detalhes_Voos detalhesVoos = detalhes_VoosExiste.get();

        Voos voo = voosRepository.findById(dadosAtualizados.vooId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Voo não encontrado com o ID"));

        detalhesVoos.setVoo(voo);
        detalhesVoos.setClasse(dadosAtualizados.classe());
        detalhesVoos.setPreco(dadosAtualizados.preco());
        detalhesVoos.setPassageiros(dadosAtualizados.passageiros());

        return detalhes_VoosRepository.save(detalhesVoos);
    }

    @Override
    public void deletarDetalhes_Voos(Long id) {
        Optional<Detalhes_Voos> detalhesVooOptional = detalhes_VoosRepository.findById(id);

        if (detalhesVooOptional.isPresent()) {
            detalhes_VoosRepository.deleteById(id);
        } else {
            throw new RecursoNaoEncontradoException(
                    "Detalhes do Voo não encontrado com o ID: " + id + " - Não é possível deletar.");
        }

    }

    @Override
    public List<Detalhes_Voos> listarDetalhesVoosPorVoo(Long vooId) {
        return detalhes_VoosRepository.findAllByVoo_Id(vooId);
    }

}

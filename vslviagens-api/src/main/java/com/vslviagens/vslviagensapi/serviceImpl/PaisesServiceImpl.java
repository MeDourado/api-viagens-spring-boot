package com.vslviagens.vslviagensapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vslviagens.vslviagensapi.exception.RecursoExistenteException;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Paises;
import com.vslviagens.vslviagensapi.repository.PaisesRepository;
import com.vslviagens.vslviagensapi.service.PaisesService;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PaisesServiceImpl implements PaisesService {

    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Paises> listarPaises() {
        return paisesRepository.findAll();
    }

    @Override
    public Paises cadastrarPais(Paises paises) {
        if (paises.getNome() == null || paises.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do país é um campo obrigatório.");
        }

        Paises paisComMesmoNome = paisesRepository.findByNome(paises.getNome());

        if (paisComMesmoNome != null) {
            throw new RecursoExistenteException("Já existe um país com este nome");
        }

        return paisesRepository.save(paises);
    }

    @Override
    @Transactional(readOnly = true)
    public Paises buscarPaisPorId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de país inválido: " + id);
        }
        Paises pais = paisesRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado com o ID: " + id));
        return pais;
    }

    public void deletarPais(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de país inválido: " + id);
        }
        Paises pais = paisesRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado com o ID: " + id));

        paisesRepository.delete(pais);

    }

    @Override
    public Paises atualizarPais(Long id, Paises dadosAtualizados) {
        Paises pais = paisesRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado com o ID: " + id));

        Paises paisComMesmoNome = paisesRepository.findByNome(dadosAtualizados.getNome());

        if (paisComMesmoNome != null && !paisComMesmoNome.getId().equals(id)) {
            throw new RecursoExistenteException("Já existe um país com este nome");
        } else {
            pais.setNome(dadosAtualizados.getNome());
            return paisesRepository.save(pais);
        }

    }

}

package com.vslviagens.vslviagensapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vslviagens.vslviagensapi.exception.RecursoExistenteException;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Destinos;
import com.vslviagens.vslviagensapi.model.Paises;
import com.vslviagens.vslviagensapi.repository.DestinosRepository;
import com.vslviagens.vslviagensapi.service.DestinosService;
import com.vslviagens.vslviagensapi.service.PaisesService;

@Service
public class DestinosServiceImpl implements DestinosService {

    @Autowired
    private DestinosRepository destinosRepository;

    @Autowired
    private PaisesService paisesService;

    @Override
    @Transactional(readOnly = true)
    public List<Destinos> listarDestinos() {
        return destinosRepository.findAll();
    }

    @Override
    public Destinos cadastrarDestinos(Destinos destinos) {
        Destinos destinoExistente = destinosRepository.findByDestino(destinos.getDestino());

        if (destinoExistente != null) {
            throw new RecursoExistenteException("Destino já existe");
        }

        Long paisId = destinos.getPais().getId();
        Paises paisEncontrado = paisesService.buscarPaisPorId(paisId);

        if (paisEncontrado == null) {
            throw new RecursoNaoEncontradoException("O país do destino não está definido corretamente");
        }

        destinos.setPais(paisEncontrado);

        return destinosRepository.save(destinos);
    }

    @Override
    @Transactional(readOnly = true)
    public Destinos buscarDestinoPorId(Long id) {
        Optional<Destinos> opcionalDestino = destinosRepository.findById(id);
        return opcionalDestino
                .orElseThrow(() -> new RecursoNaoEncontradoException("Destino não encontrado com o ID: " + id));
    }

    @Override
    public void deletarDestino(Long id) {
        Optional<Destinos> opcionalDestino = destinosRepository.findById(id);

        if (opcionalDestino.isPresent()) {
            destinosRepository.deleteById(id);
        }

        throw new RecursoNaoEncontradoException("Destino não encontrado com o ID: " + id);

    }

    @Override
    public Destinos atualizarDestino(Long id, Destinos dadosAtualizados) {
        Optional<Destinos> opcionalDestino = destinosRepository.findById(id);

        if (opcionalDestino.isPresent()) {
            Destinos destino = opcionalDestino.get();
            destino.setDestino(dadosAtualizados.getDestino());
            destino.setDescricao(dadosAtualizados.getDescricao());
            destino.setCep(dadosAtualizados.getCep());
            destino.setTemporadaRecomendada(dadosAtualizados.getTemporadaRecomendada());
            destino.setClima(dadosAtualizados.getClima());

            Long paisId = destino.getPais().getId();
            Paises paisEncontrado = paisesService.buscarPaisPorId(paisId);

            if (paisEncontrado == null) {
                throw new RecursoNaoEncontradoException("O país do destino não está definido corretamente");

            }

            destino.setPais(paisEncontrado);

            return destinosRepository.save(destino);
        }

        throw new RecursoNaoEncontradoException("Destino não encontrado com o ID: " + id);
    }

}

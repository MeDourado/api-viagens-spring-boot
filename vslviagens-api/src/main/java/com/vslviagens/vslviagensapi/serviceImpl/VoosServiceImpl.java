package com.vslviagens.vslviagensapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vslviagens.vslviagensapi.exception.RecursoExistenteException;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Paises;
import com.vslviagens.vslviagensapi.model.Voos;
import com.vslviagens.vslviagensapi.repository.VoosRepository;
import com.vslviagens.vslviagensapi.service.PaisesService;
import com.vslviagens.vslviagensapi.service.VoosService;

@Service
public class VoosServiceImpl implements VoosService {

    @Autowired
    private VoosRepository voosRepository;

    @Autowired
    private PaisesService paisesService;

    @Override
    public List<Voos> listarVoos() {
        return voosRepository.findAll();
    }

    @Override
    public Voos cadastrarVoo(Voos voo) {

        Voos procurarVoo = voosRepository.findByCodigo(voo.getCodigo());
        if (procurarVoo != null) {
            throw new RecursoExistenteException("Voo " + voo.getCodigo() + " já existe.");
        }
        Paises origemExiste = paisesService.buscarPaisPorId(voo.getOrigem().getId());

        Paises destinoExiste = paisesService.buscarPaisPorId(voo.getDestino().getId());

        if (destinoExiste == null || origemExiste == null) {
            throw new RecursoNaoEncontradoException("Destino ou origem não encontrados");
        }

        return voosRepository.save(voo);
    }

    @Override
    public Voos buscarVooPorId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de voo inválido: " + id);
        }

        Voos voo = voosRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Voo não encontrado com o ID: " + id));
        return voo;

    }

    @Override
    public Voos buscarVooPorCodigo(String codigo) {
        Voos voo = voosRepository.findByCodigo(codigo);
        if (voo == null) {
            throw new RecursoNaoEncontradoException("Voo " + codigo + " não encontrado.");
        }
        return voosRepository.findByCodigo(codigo);
    }

    @Override
    public void deletarVoo(Long id) {
        Optional<Voos> vooOptional = voosRepository.findById(id);

        if (vooOptional.isPresent()) {
            voosRepository.delete(vooOptional.get());
        } else {
            throw new RecursoNaoEncontradoException(
                    "Voo não encontrado com o ID: " + id + " - Não é possível deletar.");
        }
    }

    @Override
    public Voos atualizarVoo(Long id, Voos dadosAtualizados) {
        return voosRepository.findById(id)
                .map(voo -> {
                    voo.setOrigem(
                            dadosAtualizados.getOrigem() != null ? dadosAtualizados.getOrigem() : voo.getOrigem());
                    voo.setDestino(
                            dadosAtualizados.getDestino() != null ? dadosAtualizados.getDestino() : voo.getDestino());
                    voo.setCodigo(
                            dadosAtualizados.getCodigo() != null && !dadosAtualizados.getCodigo().isEmpty()
                                    ? dadosAtualizados.getCodigo()
                                    : voo.getCodigo());
                    voo.setPartida(
                            dadosAtualizados.getPartida() != null ? dadosAtualizados.getPartida() : voo.getPartida());
                    voo.setChegada(
                            dadosAtualizados.getChegada() != null ? dadosAtualizados.getChegada() : voo.getChegada());

                    return voosRepository.save(voo);
                })
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Voo não encontrado com o ID: " + id + " - Não é possível atualizar."));
    }

}

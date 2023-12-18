package com.vslviagens.vslviagensapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vslviagens.vslviagensapi.exception.CampoVazioException;
import com.vslviagens.vslviagensapi.model.Voos;
import com.vslviagens.vslviagensapi.service.VoosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/voos")
public class VoosController {

    @Autowired
    private VoosService voosService;

    @GetMapping
    public ResponseEntity<List<Voos>> listarVoos() {
        List<Voos> listaVoos = voosService.listarVoos();
        return ResponseEntity.ok(listaVoos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voos> buscarVooPorId(@PathVariable Long id) {
        Voos voo = voosService.buscarVooPorId(id);
        if (voo != null) {
            return ResponseEntity.ok(voo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrarVoos(@Valid @RequestBody Voos voo) {

        if (voo.getCodigo().isEmpty()) {
            throw new CampoVazioException("O código não pode estar vazio.");
        }
        Voos vooAdicionado = voosService.cadastrarVoo(voo);

        return ResponseEntity.status(HttpStatus.CREATED).body(vooAdicionado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVoo(@PathVariable Long id) {
        voosService.deletarVoo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voos> atualizarVoo(@PathVariable Long id, @RequestBody Voos dadosAtualizados) {
        Voos vooAtualizado = voosService.atualizarVoo(id, dadosAtualizados);
        if (vooAtualizado != null) {
            return ResponseEntity.ok(vooAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

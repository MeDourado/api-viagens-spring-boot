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

import com.vslviagens.vslviagensapi.dto.DetalhesVoosDTO;
import com.vslviagens.vslviagensapi.model.Detalhes_Voos;
import com.vslviagens.vslviagensapi.service.DetalhesVoosService;

@RestController
@RequestMapping("/voos/detalhes")
public class Detalhes_VoosController {

    @Autowired
    private DetalhesVoosService detalhesVoosService;

    @PostMapping
    public ResponseEntity<?> cadastrarDetalhesDoVoo(@RequestBody DetalhesVoosDTO detalhesVoosDTO) {
        Detalhes_Voos detalhesDoVoo = detalhesVoosService.cadastrarDetalhesVoosDTO(detalhesVoosDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(detalhesDoVoo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalhes_Voos> atualizarDetalhesDoVoo(@PathVariable Long id,
            @RequestBody DetalhesVoosDTO detalhesVoosDTO) {

        Detalhes_Voos detalhesDoVoo = detalhesVoosService.atualizarDetalhes_Voos(id, detalhesVoosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhesDoVoo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDetalhesDoVoo(@PathVariable Long id) {
        detalhesVoosService.deletarDetalhes_Voos(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-voo/{vooId}")
    public ResponseEntity<List<Detalhes_Voos>> listarDetalhesPorVoo(@PathVariable Long vooId) {
        List<Detalhes_Voos> detalhes = detalhesVoosService.listarDetalhesVoosPorVoo(vooId);
        if (detalhes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalhes);
    }
}

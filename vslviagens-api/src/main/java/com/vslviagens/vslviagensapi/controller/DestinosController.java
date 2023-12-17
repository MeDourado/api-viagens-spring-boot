package com.vslviagens.vslviagensapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vslviagens.vslviagensapi.model.Destinos;
import com.vslviagens.vslviagensapi.service.DestinosService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/destinos")
public class DestinosController {
    @Autowired
    private DestinosService destinosService;

    @GetMapping
    public ResponseEntity<List<Destinos>> listarDestinos() {
        List<Destinos> destinos = destinosService.listarDestinos();
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destinos> buscarDestinoPorId(@PathVariable Long id) {
        Destinos destino = destinosService.buscarDestinoPorId(id);
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destinos> cadastrarDestino(@RequestBody Destinos destinos) {
        Destinos novoDestino = destinosService.cadastrarDestinos(destinos);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDestino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destinos> atualizarDestino(@PathVariable Long id, @RequestBody Destinos destinos) {
        Destinos destinoAtualizado = destinosService.atualizarDestino(id, destinos);
        return ResponseEntity.ok(destinoAtualizado);
    }

}

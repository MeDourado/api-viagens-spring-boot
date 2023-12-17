package com.vslviagens.vslviagensapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Paises;
import com.vslviagens.vslviagensapi.service.PaisesService;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    private PaisesService paisesService;

    @GetMapping
    public ResponseEntity<List<Paises>> listarPaises() {
        List<Paises> paises = paisesService.listarPaises();
        return ResponseEntity.ok(paises);
    }

    @PostMapping
    public ResponseEntity<Paises> cadastrarPais(@RequestBody Paises paises) {
        Paises novoPais = paisesService.cadastrarPais(paises);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> buscarPaisPorId(@PathVariable Long id) {
        try {
            Paises pais = paisesService.buscarPaisPorId(id);
            return ResponseEntity.ok(pais);
        } catch (RecursoNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paises> atualizarPais(@PathVariable Long id, @RequestBody Paises paises) {
        Paises paisAtualizado = paisesService.atualizarPais(id, paises);
        return ResponseEntity.ok(paisAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPais(@PathVariable Long id) {
        paisesService.deletarPais(id);
        return ResponseEntity.noContent().build();
    }

}

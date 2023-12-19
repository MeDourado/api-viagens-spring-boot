package com.vslviagens.vslviagensapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vslviagens.vslviagensapi.dto.DetalhesSimplesReservaDTO;
import com.vslviagens.vslviagensapi.dto.ReservasDTO;
import com.vslviagens.vslviagensapi.model.Reservas;
import com.vslviagens.vslviagensapi.service.ReservasService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservasService reservasService;

    @PostMapping
    public ResponseEntity<?> cadastrarReserva(@RequestBody ReservasDTO reservasDTO) {

        Reservas reservasAdicionada = reservasService.cadastrarReservas(reservasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarReservaPorId(@PathVariable Long id) {
        DetalhesSimplesReservaDTO reserva = reservasService.buscarReservaPorId(id);
        return ResponseEntity.ok(reserva);
    }

}

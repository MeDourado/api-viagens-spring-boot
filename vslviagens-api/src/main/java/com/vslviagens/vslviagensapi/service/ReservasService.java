package com.vslviagens.vslviagensapi.service;

import com.vslviagens.vslviagensapi.dto.DetalhesSimplesReservaDTO;
import com.vslviagens.vslviagensapi.dto.ReservasDTO;
import com.vslviagens.vslviagensapi.model.Reservas;

public interface ReservasService {

    Reservas cadastrarReservas(ReservasDTO reservasDTO);

    DetalhesSimplesReservaDTO buscarReservaPorId(Long id);
}

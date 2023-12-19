package com.vslviagens.vslviagensapi.dto;

import java.util.List;

import java.math.BigDecimal;

public record ReservasDTO(Long clienteId, Long vooId, BigDecimal totalReserva, List<Pedidos_ReservasDTO> pedidos) {

}

package com.vslviagens.vslviagensapi.dto;

import java.math.BigDecimal;

public record DetalhesSimplesReservaDTO(Long id, String nomeCliente, String codigoVoo, BigDecimal totalReserva) {
}

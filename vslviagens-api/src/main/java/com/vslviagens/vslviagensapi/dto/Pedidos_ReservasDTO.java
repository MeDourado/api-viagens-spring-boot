package com.vslviagens.vslviagensapi.dto;

import java.math.BigDecimal;

public record Pedidos_ReservasDTO(Long ReservaId, int quantidade, Long produtoId, BigDecimal total) {

}

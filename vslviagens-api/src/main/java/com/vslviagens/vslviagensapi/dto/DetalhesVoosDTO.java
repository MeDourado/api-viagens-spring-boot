package com.vslviagens.vslviagensapi.dto;

import com.vslviagens.vslviagensapi.model.ClasseVooRole;

public record DetalhesVoosDTO(Long vooId, ClasseVooRole classe, double preco, int passageiros) {
}

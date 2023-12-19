package com.vslviagens.vslviagensapi.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vslviagens.vslviagensapi.dto.DetalhesSimplesReservaDTO;
import com.vslviagens.vslviagensapi.dto.Pedidos_ReservasDTO;
import com.vslviagens.vslviagensapi.dto.ReservasDTO;
import com.vslviagens.vslviagensapi.exception.RecursoInvalidoException;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;
import com.vslviagens.vslviagensapi.model.Detalhes_Voos;
import com.vslviagens.vslviagensapi.model.Pedidos_Reservas;
import com.vslviagens.vslviagensapi.model.Reservas;
import com.vslviagens.vslviagensapi.model.Usuarios;
import com.vslviagens.vslviagensapi.model.Voos;
import com.vslviagens.vslviagensapi.repository.Detalhes_VoosRepository;
import com.vslviagens.vslviagensapi.repository.ReservasRepository;
import com.vslviagens.vslviagensapi.repository.UsuariosRepository;
import com.vslviagens.vslviagensapi.repository.VoosRepository;
import com.vslviagens.vslviagensapi.service.ReservasService;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private VoosRepository voosRepository;

    @Autowired
    private Detalhes_VoosRepository detalhes_VoosRepository;

    @Override
    public Reservas cadastrarReservas(ReservasDTO reservasDTO) {
        Usuarios cliente = usuariosRepository.findById(reservasDTO.clienteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado com o ID: "));

        Reservas novaReserva = new Reservas();
        novaReserva.setCliente(cliente);

        Voos voo = voosRepository.findById(reservasDTO.vooId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Voo não encontrado com o ID: "));

        novaReserva.setVoo(voo);
        novaReserva.setTotalreserva(reservasDTO.totalReserva());

        List<Pedidos_Reservas> pedidos = new ArrayList<>();
        BigDecimal totalReserva = BigDecimal.ZERO;

        for (Pedidos_ReservasDTO pedidoDTO : reservasDTO.pedidos()) {
            Pedidos_Reservas novoPedido = new Pedidos_Reservas();
            novoPedido.setReserva(novaReserva);

            Detalhes_Voos detalheVoo = detalhes_VoosRepository.findById(pedidoDTO.produtoId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Detalhe do Voo não encontrado com o ID: "));
            ;

            novoPedido.setProduto(detalheVoo);
            BigDecimal quantidade = BigDecimal.valueOf(pedidoDTO.quantidade());
            BigDecimal preco = BigDecimal.valueOf(detalheVoo.getPreco());
            BigDecimal totalDoPedido = quantidade.multiply(preco);

            if (pedidoDTO.quantidade() > detalheVoo.getPassageiros()) {
                throw new RecursoInvalidoException(
                        "Pedido ultrapassou o maximo disponivel de passagens disponiveis");
            }

            novoPedido.setTotal(totalDoPedido);
            novoPedido.setQuantidade(pedidoDTO.quantidade());
            totalReserva = totalReserva.add(totalDoPedido);
            pedidos.add(novoPedido);

        }

        novaReserva.setPedidos(pedidos);
        novaReserva.setTotalreserva(totalReserva);

        for (Pedidos_ReservasDTO pedidoDTO : reservasDTO.pedidos()) {
            Detalhes_Voos detalheVoo = detalhes_VoosRepository.findById(pedidoDTO.produtoId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Detalhe do Voo não encontrado com o ID: "));

            detalheVoo.setPassageiros(detalheVoo.getPassageiros() - pedidoDTO.quantidade());
            detalhes_VoosRepository.save(detalheVoo);
        }

        return reservasRepository.save(novaReserva);

    }

    @Override
    public DetalhesSimplesReservaDTO buscarReservaPorId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de reserva inválido: " + id);
        }

        Reservas reserva = reservasRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Reserva não encontrada com o ID: " + id));

        return new DetalhesSimplesReservaDTO(
                reserva.getId(),
                reserva.getCliente().getNome(),
                reserva.getVoo().getCodigo(),
                reserva.getTotalreserva());
    }

}

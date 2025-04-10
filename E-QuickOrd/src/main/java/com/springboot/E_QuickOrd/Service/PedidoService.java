package com.springboot.E_QuickOrd.Service;

import com.springboot.E_QuickOrd.Model.Cliente;
import com.springboot.E_QuickOrd.Model.Pedido;
import com.springboot.E_QuickOrd.Model.StatusPedido;
import com.springboot.E_QuickOrd.Repository.ClienteRepository;
import com.springboot.E_QuickOrd.Repository.PedidoRepository;
import com.springboot.E_QuickOrd.dto.PedidoResponseDto;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Builder
public class PedidoService {

        private final PedidoRepository pedidoRepository;
        private final ClienteRepository clienteRepository;

        @Transactional
        public Pedido criarPedido(Pedido pedido) {


            if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
                throw new RuntimeException("Cliente é obrigatório");
            }

            // Verifica se o cliente existe no banco de dados
            Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            pedido.setCliente(cliente); // Associa o cliente ao pedido
            pedido.setDataHora(LocalDateTime.now()); // Define a data e hora atual
            pedido.setStatus(StatusPedido.PENDENTE);

            // Calcula o valor total do pedido
            pedido.setValorTotal(pedido.getItens().stream()
                    .map(item -> item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

            // Salva o pedido no banco de dados
            return pedidoRepository.save(pedido);

        }

    //Retorno do DTO
    public PedidoResponseDto buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getDataHora(),
                pedido.getStatus().name(),
                pedido.getValorTotal()
        );
    }


}

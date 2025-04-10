package com.springboot.E_QuickOrd.Controller;

import com.springboot.E_QuickOrd.Model.Pedido;
import com.springboot.E_QuickOrd.Service.PedidoService;
import com.springboot.E_QuickOrd.dto.PedidoResponseDto;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/E-Oder/pedido")
@Builder
public class PedidoRepository {

        private final PedidoService pedidoService;

        //Criar um pedido
        @PostMapping
        public ResponseEntity<Pedido> criarPedido(Pedido pedido) {
            Pedido novoPedido = pedidoService.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido);
        }

        //Listar pedidos ativos
        @GetMapping("/{id}")
        public ResponseEntity<PedidoResponseDto> buscarPedidoPorId(@PathVariable Long id) {
            PedidoResponseDto pedidoResponseDto = pedidoService.buscarPedidoPorId(id);
            return ResponseEntity.ok(pedidoResponseDto);
        }

}

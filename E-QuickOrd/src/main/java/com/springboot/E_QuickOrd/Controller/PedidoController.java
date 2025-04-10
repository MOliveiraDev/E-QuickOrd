package com.springboot.E_QuickOrd.Controller;

import com.springboot.E_QuickOrd.Model.Pedido;
import com.springboot.E_QuickOrd.Service.PedidoService;
import com.springboot.E_QuickOrd.dto.PedidoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/E-Order/pedidos")
@RequiredArgsConstructor
public class PedidoController {  // Nome alterado para PedidoController

    private final PedidoService pedidoService;

    // Criar um pedido
    @PostMapping("/criar")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> buscarPedidoPorId(@PathVariable Long id) {
        PedidoResponseDto pedidoResponseDto = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoResponseDto);
    }


}
package com.springboot.E_QuickOrd.Controller;

import com.springboot.E_QuickOrd.Model.Produto;
import com.springboot.E_QuickOrd.Service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/E-Order/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    // Criar um produto
    @PostMapping("/criar")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    // Listar produtos ativos
    @GetMapping("/ativos")
    public ResponseEntity<Iterable<Produto>> listarProdutosAtivos() {
        Iterable<Produto> produtosAtivos = produtoService.listarProdutosAtivos();
        return ResponseEntity.ok(produtosAtivos);
    }

    // Desativar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarProduto(@PathVariable Long id) {
        produtoService.desativarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
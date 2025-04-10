package com.springboot.E_QuickOrd.Service;

import com.springboot.E_QuickOrd.Model.Produto;
import com.springboot.E_QuickOrd.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Builder
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    //Criar um produto
    @Transactional
    public Produto criarProduto(Produto produto) {

        //Tem que ser maior que 0
        if (produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }

        //O preço não pode ser negativo
        if (produto.getPreco().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }


        return produtoRepository.save(produto);
    }

    //Listar produtos ativos
    public List <Produto> listarProdutosAtivos() {
        return produtoRepository.findByAtivoTrue();
    }

    //Desativando um produto
    @Transactional
    public void desativarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produto.setAtivo(false);
        produtoRepository.save(produto);
    }
}

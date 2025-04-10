package com.springboot.E_QuickOrd.Repository;

import com.springboot.E_QuickOrd.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByAtivoTrue();
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}

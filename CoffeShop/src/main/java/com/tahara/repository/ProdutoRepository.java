package com.tahara.repository;

import com.tahara.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Long>{
}

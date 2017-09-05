package com.tahara.controllers;

import com.tahara.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tahara.repository.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(path="/produtos/{id}")
    public String produto(@PathVariable Long id, Model model){
        model.addAttribute("produto", produtoRepository.findOne(id));
        return "produto";
    }

    @GetMapping(path="/produtos")
    public String produtoLista(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos";
    }

    @PostMapping(path="/saveproduto")
    @ResponseBody
    public String saveProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return produto.getProdutoId().toString();
    }

}

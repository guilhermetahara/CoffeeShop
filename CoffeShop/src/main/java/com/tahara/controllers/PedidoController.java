package com.tahara.controllers;

import com.tahara.models.Consumidor;
import com.tahara.models.Pedido;
import com.tahara.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tahara.repository.ConsumidorRepository;
import com.tahara.repository.PedidoRepository;
import com.tahara.repository.ProdutoRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
public class PedidoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @GetMapping(path="/pedidos")
    public String pedidoLista(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedidos";
    }

    @PostMapping(path="/criarpedido")
    @ResponseBody
    public String savePedido(@RequestParam String Nome, @RequestParam(value="produtoIds[]") Long [] produtoIds){

        Consumidor consumidor = new Consumidor();
        consumidor.setConsumidorNome(Nome);
        consumidorRepository.save(consumidor);

        Pedido pedido = new Pedido();
        pedido.setConsumidor(consumidorRepository.findOne(consumidor.getConsumidorId()));

        Set<Produto> produtoSet = new HashSet<Produto>();

        for (Long produtoId:produtoIds){
            produtoSet.add(produtoRepository.findOne(produtoId));
        }
        pedido.setProdutos(produtoSet);

        Double total = 0.0;

        for(Long produtoId:produtoIds){
            total = total+(produtoRepository.findOne(produtoId).getProdutoPreco());
        }

        pedido.setTotal(total);

        pedidoRepository.save(pedido);

        return pedido.getPedidoId().toString();
    }

    @PostMapping("/removerpedido")
    @ResponseBody
    public String removePedido(@RequestParam Long Id){
        pedidoRepository.delete(Id);
        return Id.toString();
    }


}

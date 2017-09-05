package com.tahara;

import com.tahara.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tahara.repository.ConsumidorRepository;
import com.tahara.repository.PedidoRepository;
import com.tahara.repository.ProdutoRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    ProdutoRepository productRepository;

    @Autowired
    ConsumidorRepository customerRepository;

    @Autowired
    PedidoRepository orderRepository;



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {

        Produto expresso = new Produto();
        expresso.setProdutoNome("Expresso");
        expresso.setProdutoPreco(3.95);

        Produto capuccinno = new Produto();
        capuccinno.setProdutoNome("Capuccinno");
        capuccinno.setProdutoPreco(4.95);

        productRepository.save(expresso);
        productRepository.save(capuccinno);


    }


}
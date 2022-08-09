package com.primeiroProjetoSpringBoot.myfirstprojet;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    /*
     * Maneira errada de falar que preciso deste objeto, dessa forma sou dependente
     * dele.
     * O jeito certo é por injecao de dependecia, temos varias formas de usar a
     * injeção, 1-pelo construtor, 2-set, 3-frameWork que faz as coisas por baixo
     * dos panos para vc, e é isso que vamos usar, um framework spring
     * 
     */

    // jeito errado -> private ProductRepository ProductRepository = new
    // CategoryRepository();
    // jeito certo com framework spring, tenho que adicionar: @Autowired na classe
    // que serar injetada, na classe do obj que serar injetado devo adicionar o
    // @component no CategoryRepository
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productRepository.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product p = productRepository.findById(id).get();
        return ResponseEntity.ok().body(p);
    }

}

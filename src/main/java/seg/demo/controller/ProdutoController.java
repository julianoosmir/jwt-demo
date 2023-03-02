package seg.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
     
    @GetMapping
    public String testGet(){
        return "testando get produto";
    }
    @PostMapping
    public String testPost(){
        return "testando post produto";
    }
    @DeleteMapping
    public String testDelete(){
        return "testando delete produto";
    }
}

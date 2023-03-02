package seg.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
    
    @GetMapping
    public String testGet(){
        return "testando get pedido";
    }
    @PostMapping
    public String testPost(){
        return "testando post pedido";
    }
    @DeleteMapping
    public String testDelete(){
        return "testando delete pedido";
    }
    
}

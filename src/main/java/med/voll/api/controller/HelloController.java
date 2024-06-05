package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informando que essa classe é um controller
@RequestMapping("/hello") // está vai ser a rota da aplicação
public class HelloController {

    @GetMapping // tipo get para exibir
    public String olaMundo() {
        return "Hello Word Spring!";
    }
}

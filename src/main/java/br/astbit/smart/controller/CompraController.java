package br.astbit.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compras")
public class CompraController {
    
    @GetMapping
    public String carregaPaginaFormulario(){
        return "compra/formulario";
    }
}

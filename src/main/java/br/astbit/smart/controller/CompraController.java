package br.astbit.smart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.astbit.smart.model.compra.Compra;
import br.astbit.smart.model.compra.CompraRepository;
import br.astbit.smart.model.compra.DadosCadastroCompra;

@Controller
@RequestMapping("/compras")
public class CompraController {
    
    @Autowired
    private CompraRepository compras;

    @GetMapping("/formulario")
    public String loadComprasForm(){
        return "compra/formulario";
    }

    @GetMapping
    public String loadComprasListagem(Model model){
        model.addAttribute("lista", compras.findAll());
        return "compra/listagem";
    }

    @PostMapping
    public String cadastraCompra(DadosCadastroCompra dados){
        Compra c = new Compra(dados);
        compras.save(c);
        return "redirect:/compras";
    }
    
}

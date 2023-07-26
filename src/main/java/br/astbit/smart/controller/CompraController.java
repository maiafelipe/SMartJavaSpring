package br.astbit.smart.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.astbit.smart.model.compra.Compra;
import br.astbit.smart.model.compra.CompraRepository;
import br.astbit.smart.model.compra.DadosAtualizaCompra;
import br.astbit.smart.model.compra.DadosCadastroCompra;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/compras")
public class CompraController {
    Logger logger = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraRepository repository;

    @GetMapping("/formulario")
    public String loadComprasForm(Long id, Model model){
        if (id != null) {
            logger.info("Carregando formulario para edita a compra: " + id + ".");
            Compra compra = repository.getReferenceById(id);
            model.addAttribute("compra", compra);
        }
        return "compra/formulario";
    }

    @GetMapping
    public String loadComprasListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "compra/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCompra(DadosCadastroCompra dados){
        logger.info("Cadastrando uma compra.");
        Compra c = new Compra(dados);
        repository.save(c);
        return "redirect:/compras";
    }

    @DeleteMapping
    @Transactional
    public String removeCompra(Long id){
        logger.info("Deletando a compra: " + id + ".");
        repository.deleteById(id);
        return "redirect:/compras";
    }

    @PutMapping
    @Transactional
    public String atualizaCompra(DadosAtualizaCompra dados){
        logger.info("Atualizando a compra: " + dados.id() + ".");
        Compra c = repository.getReferenceById(dados.id());
        c.atualizaCompra(dados);
        return "redirect:/compras";
    }
    
}

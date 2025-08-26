package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Essa é minha primeira mensagem ne   ssa porta";
    }

    //adicionar ninja
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "ninja criado";
    }

    //mostrar todos os ninja
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.ListarNinjas();
    }

    //mostrar ninja por id
    @GetMapping("/todosID")
    public List<NinjaModel> listarNinjasPorId(){
        return ninjaService.listarNinjaPorId();
    }
    //alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String alterarDadosDoNinja(){
        return "alterar dados";
    }

    //deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "deletar";
    }
}

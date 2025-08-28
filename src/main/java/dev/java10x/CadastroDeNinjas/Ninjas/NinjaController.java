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
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.adicionarNinja(ninja);
    }

    //mostrar todos os ninja
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.ListarNinjas();
    }

    //mostrar ninja por id
    @GetMapping("/todos/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    //alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarDadosDoNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
         ninjaService.deletarNinja(id);
    }

}

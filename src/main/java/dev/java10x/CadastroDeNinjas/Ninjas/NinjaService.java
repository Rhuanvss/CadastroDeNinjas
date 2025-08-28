package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar Ninjas
    public List<NinjaModel> ListarNinjas(){
        return ninjaRepository.findAll();
    }

    //listar Ninja por ID
    public NinjaModel listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //adicionar ninja
    public NinjaModel adicionarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //deletar ninja
    public void deletarNinja(Long id){
         ninjaRepository.deleteById(id);
    }

    //atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}

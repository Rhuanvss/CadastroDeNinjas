package dev.java10x.CadastroDeNinjas.Ninjas;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    // Listar Ninjas
    public List<NinjaDTO> ListarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toUnmodifiableList());
    }

    //listar Ninja por ID
    public NinjaDTO listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //adicionar ninja
    public NinjaDTO adicionarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //deletar ninja
    public void deletarNinja(Long id){
         ninjaRepository.deleteById(id);
    }

    //atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistetnte = ninjaRepository.findById(id);
        if (ninjaExistetnte.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjasalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjasalvo);
        }
        return null;
    }
}

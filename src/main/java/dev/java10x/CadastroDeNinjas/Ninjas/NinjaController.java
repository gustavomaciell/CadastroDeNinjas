package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esta é minha primeira mensagem nessa rota.";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity criarNinja(@RequestBody NinjaDTO ninja) {
     NinjaDTO novoNinja= ninjaService.criarNinja(ninja);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Ninja " + novoNinja.getNome() + " criado com sucesso!");
    }

    // Mostrar todos os ninjas(CREATE)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado.");
        }
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
         NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
         if (ninja != null) {
             NinjaDTO ninjaSalvo = ninjaService.atualizarNinja(id, ninjaAtualizado);
             return ResponseEntity.ok(ninjaSalvo);
         }else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Ninja com o id " + id + " não encontrado.");
         }
    }

    //Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum ninja foi encontrado");
        }
        return ResponseEntity.ok("Ninja deletado com sucesso!");
    }
}

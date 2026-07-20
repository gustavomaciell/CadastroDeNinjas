package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esta é minha primeira mensagem nessa rota.";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas(CREATE)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas() {
        return "Mostrar ninjas";
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrar ninjas por id";
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Alterar ninja por id";
    }
    //Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }
}

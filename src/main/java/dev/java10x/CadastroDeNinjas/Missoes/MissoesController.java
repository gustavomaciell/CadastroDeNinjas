package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //GET -> Mandar uma requisicao para listar as missoes
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missões listadas com sucesso";
    }

    //POST -> Mandar uma requisiçao para criar as missoes
    @PostMapping("/criar")
    public String criarMissoes() {
        return "Missão criada com sucesso";
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissoes() {
        return "Missão alterada com sucesso";
    }

    //DELETE -> Manda uma requisicao para deletar uma missao
    @DeleteMapping("/deletar")
    public String deletarMissoe() {
        return "Missão deletada com sucesso";
    }
}

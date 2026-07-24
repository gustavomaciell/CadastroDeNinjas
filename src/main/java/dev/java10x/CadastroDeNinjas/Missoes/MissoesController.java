package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -> Mandar uma requisicao para listar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }
    @GetMapping("/listar/{id}")
    public MissoesModel missoesModel(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //POST -> Mandar uma requisiçao para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    //PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissoes() {
        return "Missão alterada com sucesso";
    }

    //DELETE -> Manda uma requisicao para deletar uma missao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoe(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }
}

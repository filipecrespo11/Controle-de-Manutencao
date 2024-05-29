package com.ti.mpreventiva.Controllers.APIRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ti.mpreventiva.DTO.DadosAdicionarManutencao;
import com.ti.mpreventiva.DTO.DadosAtualizarManutencao;
import com.ti.mpreventiva.Entities.Manutencao;
import com.ti.mpreventiva.Services.ManutencaoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manutencoes")
public class ManutencaoRestController {

    @Autowired
    private ManutencaoService manutencaoService;

    @PostMapping("/add")
    public ResponseEntity<Manutencao> adicionarManutencao(@RequestBody DadosAdicionarManutencao dados) {
        Manutencao manutencao = manutencaoService.adicionarManutencao(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(manutencao);
    }

    @GetMapping("/find/{id_manutencao}")
    public ResponseEntity<Manutencao> buscarPorId(@PathVariable Long id_manutencao) {
        Manutencao manutencao = manutencaoService.buscarPorId(id_manutencao);
        return ResponseEntity.ok(manutencao);
    }

    @PutMapping("/att/{id_manutencao}")
    public ResponseEntity<Manutencao> atualizarManutencao(@PathVariable Long id_manutencao, @RequestBody DadosAtualizarManutencao dados) {
        Manutencao manutencaoAtualizada = manutencaoService.atualizarManutencao(id_manutencao, dados);
        return ResponseEntity.ok(manutencaoAtualizada);
    }

    @DeleteMapping("/del/{id_manutencao}")
    public ResponseEntity<Void> deletarManutencao(@PathVariable Long id_manutencao) {
        manutencaoService.deletarManutencao(id_manutencao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Manutencao>> listarManutencoes() {
        List<Manutencao> manutencoes = manutencaoService.listarManutencoes();
        return ResponseEntity.ok(manutencoes);
    }
}

package br.insper.loja.campeonato;

import br.insper.loja.partida.model.Partida;
import br.insper.loja.partida.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;


    @Autowired
    private PartidaService partidaService;

    @GetMapping("/campeonato")
    public List<Campeonato> getCampeonatos(@RequestParam(required = false) String nome) {
        return campeonatoService.listarCampeonatos(nome);
    }

    @GetMapping("/campeonato/{identificador}")
    public Campeonato getCampeonato(@PathVariable Integer identificador) {
        return campeonatoService.getCampeonato(identificador);
    }


    @GetMapping("/campeonato/{identificador}/partidas")
    public ArrayList<Partida> getCampeonatoPartidas(@PathVariable String identificador) {
        return partidaService.listarPartidasCampeonato(identificador);
    }

    @PostMapping("/campeonato")
    public Campeonato salvarCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.cadastrarCampeonato(campeonato);
    }

}

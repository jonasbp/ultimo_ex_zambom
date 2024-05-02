package br.insper.loja.partida.controller;

import br.insper.loja.partida.dto.RetornarPartidaDTO;
import br.insper.loja.partida.dto.SalvarPartidaDTO;
import br.insper.loja.partida.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/partida")
    public List<RetornarPartidaDTO> getPartida(@RequestParam(required = false) String mandante) {
        return partidaService.listarPartidas(mandante);
    }

    @PostMapping("/partida")
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarPartidaDTO salvarPartida(@RequestBody SalvarPartidaDTO partida) {
        return partidaService.cadastrarPartida(partida);
    }

}

package br.insper.loja.time;

import br.insper.loja.partida.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/time")
    public List<Time> getTimes(@RequestParam(required = false) String estado) {
        return timeService.listarTimes(estado);
    }

    @GetMapping("/time/{identificador}")
    public Time getTime(@PathVariable Integer identificador) {
        return timeService.getTime(identificador);
    }


    @GetMapping("/time/{identificador}/vitorias")
    public Integer getVitorias(@PathVariable String identificador) {
        return partidaService.contaVitorias(identificador);
    }

    @PostMapping("/time")
    @ResponseStatus(HttpStatus.CREATED)
    public Time salvarTime(@RequestBody Time cliente) {
        return timeService.cadastrarTime(cliente);
    }


}

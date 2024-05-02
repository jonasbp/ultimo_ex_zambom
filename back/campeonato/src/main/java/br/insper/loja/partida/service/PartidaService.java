package br.insper.loja.partida.service;

import br.insper.loja.campeonato.Campeonato;
import br.insper.loja.partida.model.Partida;
import br.insper.loja.partida.repository.PartidaRepository;
import br.insper.loja.partida.dto.RetornarPartidaDTO;
import br.insper.loja.partida.dto.SalvarPartidaDTO;
import br.insper.loja.time.Time;
import br.insper.loja.time.TimeService;
import br.insper.loja.campeonato.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeService timeService;

    @Autowired
    private CampeonatoService campeonatoService;

    public RetornarPartidaDTO cadastrarPartida(SalvarPartidaDTO salvarPartidaDTO) {

        Time mandante = timeService.getTime(salvarPartidaDTO.getMandante());
        Time visitante = timeService.getTime(salvarPartidaDTO.getVisitante());

        Campeonato campeonato =  campeonatoService.getCampeonato(salvarPartidaDTO.getCampeonato());

        if (campeonato == null) {
            throw new RuntimeException("Campeonato na encotrado");
        }

        Partida partida = new Partida();
        partida.setCampeonato(campeonato);
        partida.setMandante(mandante);
        partida.setVisitante(visitante);
        partida.setPlacarMandante(salvarPartidaDTO.getPlacarMandante());
        partida.setPlacarVisitante(salvarPartidaDTO.getPlacarVisitante());

        partida = partidaRepository.save(partida);
        return RetornarPartidaDTO.getRetornarPartidaDTO(partida);
    }



    public List<RetornarPartidaDTO> listarPartidas(String mandante) {
        List<Partida> partidas = partidaRepository.findAll();
        if  (mandante != null) {
            ArrayList<RetornarPartidaDTO> lista = new ArrayList<>();

            for (Partida partida  : partidas) {
                if (partida.getMandante().getIdentificador().equals(mandante))  {
                    lista.add(RetornarPartidaDTO.getRetornarPartidaDTO(partida));
                }
            }
            return lista;
        }

        List<RetornarPartidaDTO> response = new ArrayList<>();
        for (Partida partida : partidas) {
            response.add(RetornarPartidaDTO.getRetornarPartidaDTO(partida));
        }
        return response;
    }

    public ArrayList<Partida> listarPartidasCampeonato(String campeonato) {

        List<Partida> partidas = partidaRepository.findAll();
        ArrayList<Partida> lista = new ArrayList<>();
        for (Partida partida  : partidas) {
            if (partida.getCampeonato().getIdentificador().equals(campeonato))  {
                lista.add(partida);
            }
        }
        return lista;
    }

    public Integer contaVitorias(String time) {

        List<Partida> partidas = partidaRepository.findAll();
        Integer total = 0;

        for (Partida partida : partidas) {
            if (partida.getMandante().getIdentificador().equals(time)) {
                if (partida.getPlacarMandante() > partida.getPlacarVisitante()) {
                    total++;
                }
            }
            if (partida.getVisitante().getIdentificador().equals(time)) {
                if (partida.getPlacarVisitante() > partida.getPlacarMandante()) {
                    total++;
                }
            }
        }


        return total;
    }

}

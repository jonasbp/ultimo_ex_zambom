package br.insper.loja.partida.repository;

import br.insper.loja.campeonato.Campeonato;
import br.insper.loja.partida.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Integer> {

    List<Partida> findByCampeonato(Campeonato campeonato);


}

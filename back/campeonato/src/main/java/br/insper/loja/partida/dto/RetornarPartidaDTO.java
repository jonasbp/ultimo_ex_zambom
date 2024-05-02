package br.insper.loja.partida.dto;

import br.insper.loja.partida.model.Partida;

public class RetornarPartidaDTO {
    private String nomeMandante;
    private String nomeVisitante;
    private Integer placarMandante;
    private Integer placarVisitante;
    private String nomeCampeonato;

    public static RetornarPartidaDTO getRetornarPartidaDTO(Partida partida) {
        RetornarPartidaDTO retornarPartidaDTO = new RetornarPartidaDTO();
        retornarPartidaDTO.setNomeMandante(partida.getMandante().getNome());
        retornarPartidaDTO.setNomeVisitante(partida.getVisitante().getNome());
        retornarPartidaDTO.setPlacarMandante(partida.getPlacarMandante());
        retornarPartidaDTO.setPlacarVisitante(partida.getPlacarVisitante());
        if (partida.getCampeonato() != null) {
            retornarPartidaDTO.setNomeCampeonato(partida.getCampeonato().getNome());
        }
        return retornarPartidaDTO;
    }

    public String getNomeMandante() {
        return nomeMandante;
    }

    public void setNomeMandante(String nomeMandante) {
        this.nomeMandante = nomeMandante;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(Integer placarMandante) {
        this.placarMandante = placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(Integer placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }

    public void setNomeCampeonato(String nomeCampeonato) {
        this.nomeCampeonato = nomeCampeonato;
    }
}

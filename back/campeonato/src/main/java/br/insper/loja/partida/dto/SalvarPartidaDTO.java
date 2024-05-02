package br.insper.loja.partida.dto;

public class SalvarPartidaDTO {
    private Integer mandante;
    private Integer visitante;
    private Integer placarMandante;
    private Integer placarVisitante;
    private Integer campeonato;

    public Integer getMandante() {
        return mandante;
    }

    public void setMandante(Integer mandante) {
        this.mandante = mandante;
    }

    public Integer getVisitante() {
        return visitante;
    }

    public void setVisitante(Integer visitante) {
        this.visitante = visitante;
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

    public Integer getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Integer campeonato) {
        this.campeonato = campeonato;
    }
}

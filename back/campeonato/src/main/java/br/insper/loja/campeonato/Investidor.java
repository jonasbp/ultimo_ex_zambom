package br.insper.loja.campeonato;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Investidor {

    @Id
    private Integer id;

    private String cpf;
}

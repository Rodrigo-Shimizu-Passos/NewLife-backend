package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Visitante;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@AllArgsConstructor
public class VisitanteDto {
    private Long idVisitante;
    private Apartamento idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String obs;

    public VisitanteDto(Visitante visitante){
        this.idVisitante=visitante.getIdVisitante();
        this.idApto=visitante.getIdApto();
        this.nome=visitante.getNome();
        this.rg=visitante.getRg();
        this.cpf=visitante.getCpf();
        this.telefone1=visitante.getTelefone1();
        this.telefone2=visitante.getTelefone2();
        this.obs=visitante.getObs();
    }
}

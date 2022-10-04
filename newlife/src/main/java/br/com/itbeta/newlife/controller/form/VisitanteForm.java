package br.com.itbeta.newlife.controller.form;

import br.com.itbeta.newlife.conversor.EntityToDto;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Visitante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VisitanteForm {
    private Long idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String obs;

    public VisitanteForm(Visitante visitante){
        this.idApto=visitante.getIdApto().getIdApto();
        this.nome=visitante.getNome();
        this.rg=visitante.getRg();
        this.cpf=visitante.getCpf();
        this.telefone1=visitante.getTelefone1();
        this.telefone2=visitante.getTelefone2();
        this.obs=visitante.getObs();
    }
}

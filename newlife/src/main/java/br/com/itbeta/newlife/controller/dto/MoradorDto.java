package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Morador;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor
public class MoradorDto {
    private Long idMorador;
    private Apartamento idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String email;
    private String contatoEmerg;
    private String telefoneEmerg;
    private String obs;

    public MoradorDto(Morador morador){
        this.idMorador=morador.getIdMorador();
        this.idApto=morador.getIdApto();
        this.nome=morador.getNome();
        this.rg=morador.getRg();
        this.cpf=morador.getCpf();
        this.telefone1=morador.getTelefone1();
        this.telefone2=morador.getTelefone2();
        this.email=morador.getEmail();
        this.contatoEmerg=morador.getContatoEmerg();
        this.telefoneEmerg= morador.getTelefoneEmerg();
        this.obs=morador.getObs();
    }
}

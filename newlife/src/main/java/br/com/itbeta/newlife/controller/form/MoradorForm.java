package br.com.itbeta.newlife.controller.form;

import br.com.itbeta.newlife.conversor.EntityToDto;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Morador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MoradorForm {
    private Long idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String email;
    private String contatoEmerg;
    private String telefoneEmerg;
    private String obs;

    public MoradorForm(Morador morador){
        this.idApto=morador.getIdApto().getIdApto();//não tinha o getIdApto
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
